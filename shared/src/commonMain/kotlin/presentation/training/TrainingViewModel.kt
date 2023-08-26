package presentation.training

import Graph
import globalKoin
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import mapping.toBody
import mapping.toTrainingState
import navigation.NavigatorCore
import repository.TrainingRepository
import utils.DateTimeKtx
import utils.ViewModel
import round

internal class TrainingViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = MutableStateFlow(TrainingState())
    val state: StateFlow<TrainingState> = _state

    private val api = globalKoin().get<TrainingRepository>()

    @FlowPreview
    fun saveTraining() = viewModelScope.launch {

        val training = state.value.training
            .validate()
            .calculateDuration()
            .calculateValues()

        if (training.exercises.isEmpty()) {
            showError("Empty training")
            return@launch
        }

        val exerciseNames = training.exercises.map { it.name }

        api.setTraining(training = training.toBody())
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                navigator.navigate(Graph.Review.link, popToInclusive = true, args = mapOf("trainingId" to it))
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.flatMapConcat {
                api.setExerciseNameOptions(exerciseNames)
            }
            .launchIn(this)
    }

    fun removeExerciseNameOption(value: String) = viewModelScope.launch {
        api
            .removeExerciseNameOption(value)
            .onEach { removedValue ->
                _state.value = state.value.copy(
                    exerciseNameOptions = state.value.exerciseNameOptions.filterNot { it == removedValue }
                )
            }.catch {
                _state.value = state.value.copy(error = it.message)
            }.launchIn(this)
    }

    fun getExerciseNameOptions() = viewModelScope.launch {
        api
            .getExerciseNameOptions()
            .onEach {
                _state.value = state.value.copy(exerciseNameOptions = it)
            }.catch {
                _state.value = state.value.copy(error = it.message)
            }.launchIn(this)
    }

    fun getTraining(trainingId: String) = viewModelScope.launch {
        api
            .getTraining(trainingId = trainingId)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    training = it
                        .toTrainingState()
                        .provideEmptyIterations()
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    private fun showError(message: String) {
        _state.value = state.value.copy(error = message)
    }

    fun openRemoveExercisePopup(exerciseId: String) {
        _state.value = state.value.copy(removeExerciseId = exerciseId)
    }

    fun openExitScreenPopup() {
        _state.value = state.value.copy(exitWarningVisibility = true)
    }

    fun closeExitScreenPopup() {
        _state.value = state.value.copy(exitWarningVisibility = false)
    }

    fun tryBack() {
        if (state.value.removeExerciseId != null) {
            closeRemoveExercisePopup()
            return
        }
        if (state.value.exitWarningVisibility.not()) {
            openExitScreenPopup()
            return
        }
        if (state.value.exitWarningVisibility) {
            closeExitScreenPopup()
        }
    }

    fun back() {
        closeExitScreenPopup()
        navigator.back()
    }

    fun closeRemoveExercisePopup() {
        _state.value = state.value.copy(removeExerciseId = null)
    }

    fun removeExercise(exerciseId: String?) {
        exerciseId?.let {
            val training = state.value.training
                .removeExercise(exerciseId)

            _state.value = state.value.copy(training = training)
        }

        closeRemoveExercisePopup()
    }

    fun updateName(exerciseId: String, name: String) {
        val training = state.value.training
            .setNameOfExercise(exerciseId, name)

        _state.value = state.value.copy(training = training)
    }

    fun updateWeight(exerciseId: String, number: Int, weight: String) {
        val training = state.value.training
            .setWeightOfIteration(exerciseId, number, weight)
            .provideEmptyIteration(exerciseId)

        _state.value = state.value.copy(training = training)
    }

    fun updateRepeat(exerciseId: String, number: Int, repeat: String) {
        val training = state.value.training
            .setRepeatOfIteration(exerciseId, number, repeat)
            .provideEmptyIteration(exerciseId)

        _state.value = state.value.copy(training = training)
    }

    fun addExercise() {
        val training = state.value.training
            .addExercise()

        _state.value = state.value.copy(training = training)
    }

    private fun Training.setNameOfExercise(id: String, name: String): Training {
        return this.copy(
            exercises = this.exercises.map {
                if (it.id == id) {
                    it.copy(name = name)
                } else it
            }
        )
    }

    private fun Training.setRepeatOfIteration(exerciseId: String, numberOfIteration: Int, repeat: String): Training {
        val exercises = this.exercises.map {
            if (it.id != exerciseId) {
                it
            } else {
                val iterations = it.iterations.mapIndexedNotNull { index, iteration ->
                    val newRepeat = if (numberOfIteration == index) repeat else iteration.repeat
                    if (newRepeat == "" && iteration.weight == "") null
                    else Iteration(weight = iteration.weight, repeat = newRepeat)
                }
                it.copy(iterations = iterations)
            }
        }
        return copy(exercises = exercises)
    }

    private fun Training.setWeightOfIteration(exerciseId: String, numberOfIteration: Int, weight: String): Training {
        val exercises = this.exercises.map {
            if (it.id != exerciseId) {
                it
            } else {
                val iterations = it.iterations.mapIndexedNotNull { index, iteration ->
                    val newWeight = if (numberOfIteration == index) weight else iteration.weight
                    if (newWeight == "" && iteration.repeat == "") null
                    else Iteration(weight = newWeight, repeat = iteration.repeat)
                }
                it.copy(iterations = iterations)
            }
        }
        return copy(exercises = exercises)
    }

    private fun Training.removeExercise(id: String): Training {
        val newList = this.exercises.mapNotNull { old -> if (old.id == id) null else old }
        return this.copy(exercises = newList)
    }

    private fun Training.addExercise(): Training {
        val newExercises = this.exercises + Exercise()
        return this.copy(exercises = newExercises)
    }

    private fun Training.validate(): Training {
        val exercises = exercises.mapNotNull {
            val isNameValid = it.name.isNotBlank()
            val iterations = it.iterations.filter { iteration ->
                val repeat = iteration.repeat.toIntOrNull()
                val weight = iteration.weight.toDoubleOrNull()
                val isRepeatValid = repeat != null && repeat > 0.0
                val isWeightValid = weight != null && weight > 0
                isRepeatValid && isWeightValid
            }
            if (isNameValid && iterations.isNotEmpty()) it.copy(iterations = iterations)
            else null
        }
        return this.copy(exercises = exercises)
    }

    private fun Training.calculateValues(): Training {
        val calculatedExercises = exercises.map {
            val exTonnage = it.iterations.sumOf { iteration ->
                (iteration.repeat.toIntOrNull() ?: 0) * (iteration.weight.toDoubleOrNull() ?: 0.0)
            }
            val exCountOfLifting = it.iterations.sumOf { iteration ->
                iteration.repeat.toIntOrNull() ?: 0
            }
            val exIntensity = (exTonnage / exCountOfLifting)
            it.copy(
                tonnage = exTonnage.round(2),
                countOfLifting = exCountOfLifting,
                intensity = exIntensity.round(1)
            )
        }

        val trainTonnage = calculatedExercises.sumOf { it.tonnage }
        val trainCountOfLifting = calculatedExercises.sumOf { it.countOfLifting }
        val trainIntensity = trainTonnage / trainCountOfLifting

        return this.copy(
            exercises = calculatedExercises,
            tonnage = trainTonnage.round(2),
            countOfLifting = trainCountOfLifting,
            intensity = trainIntensity.round(1)
        )
    }

    private fun Training.calculateDuration(): Training {
        return if (duration == null) this.copy(duration = DateTimeKtx.durationFrom(this.startDateTime))
        else this
    }

    private fun Training.provideEmptyIterations(): Training {
        return this.copy(
            exercises = exercises.map {
                val lastIsNotEmpty = it.iterations.lastOrNull()?.weight != "" || it.iterations.lastOrNull()?.repeat != ""
                if (lastIsNotEmpty) it.copy(iterations = it.iterations + Iteration())
                else it
            }
        )
    }

    private fun Training.provideEmptyIteration(exerciseId: String): Training {
        val exercise = this.exercises.find { it.id == exerciseId } ?: return this
        val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repeat != ""
        if (lastIsNotEmpty.not()) return this
        val newExercise = exercise.copy(iterations = exercise.iterations + Iteration())
        val newExercises = this.exercises.map { if (it.id == exerciseId) newExercise else it }
        return this.copy(exercises = newExercises)
    }
}