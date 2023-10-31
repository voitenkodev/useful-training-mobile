package trainingbuilder.screen

import DateTimeKtx
import TrainingsRepository
import ViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import org.koin.core.component.inject
import round
import trainingbuilder.mapping.toBody
import trainingbuilder.mapping.toTrainingState
import trainingbuilder.state.Exercise
import trainingbuilder.state.Iteration
import trainingbuilder.state.State
import trainingbuilder.state.Training

internal class TrainingViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val trainingsApi by inject<TrainingsRepository>()

    @FlowPreview
    fun saveTraining(onSuccess: (trainingId: String) -> Unit) {

        val training = state.value.training
            .validate()
            .calculateDuration()
            .calculateValues()

        if (training.exercises.isEmpty()) {
            showError("Empty training")
            return
        }

        trainingsApi.setTraining(training = training.toBody())
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                it ?: return@onEach
                onSuccess.invoke(it)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }
            .launchIn(this)
    }

    fun removeExerciseNameOption(value: String) {

    }

    fun getExerciseNameOptions() {

    }

    fun getTraining(trainingId: String) {
        trainingsApi
            .observeTraining(trainingId = trainingId)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.filterNotNull()
            .onEach {
                _state.value = state.value.copy(
                    training = it
                        .toTrainingState()
                        .provideEmptyIterations(),
                    loading = false,
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

    fun openRemoveExercisePopup(exerciseIndex: Int) {
        _state.value = state.value.copy(removeExerciseIndex = exerciseIndex)
    }

    fun openExitScreenPopup() {
        _state.value = state.value.copy(exitWarningVisibility = true)
    }

    fun closeExitScreenPopup() {
        _state.value = state.value.copy(exitWarningVisibility = false)
    }

    fun tryBack() {
        if (state.value.removeExerciseIndex != null) {
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

    fun closeRemoveExercisePopup() {
        _state.value = state.value.copy(removeExerciseIndex = null)
    }

    fun removeExercise(exerciseIndex: Int?) {

        exerciseIndex?.let {
            val training = state.value.training
                .removeExercise(exerciseIndex)

            _state.value = state.value.copy(training = training)
        }

        closeRemoveExercisePopup()
    }

    fun updateName(exerciseIndex: Int, name: String) {
        val training = state.value.training
            .setNameOfExercise(exerciseIndex, name)

        _state.value = state.value.copy(training = training)
    }

    fun updateWeight(exerciseIndex: Int, number: Int, weight: String) {
        val training = state.value.training
            .setWeightOfIteration(exerciseIndex, number, weight)
            .provideEmptyIteration(exerciseIndex)

        _state.value = state.value.copy(training = training)
    }

    fun updateRepeat(exerciseIndex: Int, number: Int, repeat: String) {
        val training = state.value.training
            .setRepeatOfIteration(exerciseIndex, number, repeat)
            .provideEmptyIteration(exerciseIndex)

        _state.value = state.value.copy(training = training)
    }

    fun addExercise() {
        val training = state.value.training
            .addExercise()

        _state.value = state.value.copy(training = training)
    }

    private fun Training.setNameOfExercise(exerciseIndex: Int, name: String): Training {
        return this.copy(
            exercises = this.exercises.mapIndexed { index, item ->
                if (exerciseIndex == index) {
                    item.copy(name = name)
                } else item
            }
        )
    }

    private fun Training.setRepeatOfIteration(exerciseIndex: Int, numberOfIteration: Int, repeat: String): Training {
        val exercises = this.exercises.mapIndexed { index, item ->
            if (exerciseIndex != index) {
                item
            } else {
                val iterations = item.iterations.mapIndexedNotNull { iterationIndex, iteration ->
                    val newRepeat = if (numberOfIteration == iterationIndex) repeat else iteration.repeat
                    if (newRepeat == "" && iteration.weight == "") null
                    else Iteration(weight = iteration.weight, repeat = newRepeat)
                }
                item.copy(iterations = iterations)
            }
        }
        return copy(exercises = exercises)
    }

    private fun Training.setWeightOfIteration(exerciseIndex: Int, numberOfIteration: Int, weight: String): Training {
        val exercises = this.exercises.mapIndexed { index, item ->
            if (exerciseIndex != index) {
                item
            } else {
                val iterations = item.iterations.mapIndexedNotNull { iterationIndex, iteration ->
                    val newWeight = if (numberOfIteration == iterationIndex) weight else iteration.weight
                    if (newWeight == "" && iteration.repeat == "") null
                    else Iteration(weight = newWeight, repeat = iteration.repeat)
                }
                item.copy(iterations = iterations)
            }
        }
        return copy(exercises = exercises)
    }

    private fun Training.removeExercise(exerciseIndex: Int): Training {
        val newList = this.exercises.mapIndexedNotNull { index, old -> if (exerciseIndex == index) null else old }
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
        return if (duration == null) this.copy(duration = DateTimeKtx.minutesFrom(this.startDateTime))
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

    private fun Training.provideEmptyIteration(exerciseIndex: Int): Training {
        val exercise = this.exercises.getOrNull(exerciseIndex) ?: return this
        val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repeat != ""
        if (lastIsNotEmpty.not()) return this
        val newExercise = exercise.copy(iterations = exercise.iterations + Iteration())
        val newExercises = this.exercises.mapIndexed() { index, item -> if (index == exerciseIndex) newExercise else item }
        return this.copy(exercises = newExercises)
    }
}