package presentation.training

import Graph
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.mapping.toBody
import data.repository.TrainingRepositoryImpl
import data.source.network.AuthSource
import data.source.network.Client
import data.source.network.TrainingSource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.DateTimeKtx
import utils.ViewModel

internal class TrainingViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = mutableStateOf(TrainingState())
    val state: State<TrainingState> = _state

    private val datastore = DataStoreFactory.client
    private val network = Client(dataStore = datastore).address()
    private val api = TrainingRepositoryImpl(TrainingSource(network))

    fun saveTraining(training: Training) = viewModelScope.launch {
        if (training.exercises.isEmpty()) {
            showError("Empty training")
            return@launch
        }

        api.setTraining(training = training.toBody())
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                navigator.navigate(Graph.Review.link, popToInclusive = true, args = mapOf("trainingId" to it))
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }
            .launchIn(this)
    }

    fun processingTraining() {
        val training = state.value.training
            .validate()
            .calculateDuration()
            .calculateValues()

        _state.value = state.value.copy(training = training)
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
        val training = state.value.training.addExercise()
        _state.value = state.value.copy(training = training)
    }

    private fun Training.setNameOfExercise(id: String, name: String): Training {
        return this.copy(exercises = this.exercises.map {
            if (it.id == id) {
                it.copy(name = name)
            } else it
        })
    }

    private fun Training.setRepeatOfIteration(exerciseId: String, numberOfIteration: Int, repeat: String): Training {
        val exercises = this.exercises.map {
            if (it.id != exerciseId) {
                it
            } else {
                val iterations = it.iterations.mapIndexedNotNull { index, iteration ->
                    val newRepeat = if (numberOfIteration == index) repeat else iteration.repeat
                    if (newRepeat == "" && iteration.weight == "") null
                    else Training.Exercise.Iteration(weight = iteration.weight, repeat = newRepeat)
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
                    else Training.Exercise.Iteration(weight = newWeight, repeat = iteration.repeat)
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
        val newExercises = this.exercises + Training.Exercise()
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
        fun Double.round(decimals: Int): Double {
            var multiplier = 1.0
            repeat(decimals) { multiplier *= 10 }
            return kotlin.math.round(this * multiplier) / multiplier
        }

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

    fun Training.provideEmptyIterations(): Training {
        return this.copy(
            exercises = exercises.map {
                val lastIsNotEmpty = it.iterations.lastOrNull()?.weight != "" || it.iterations.lastOrNull()?.repeat != ""
                if (lastIsNotEmpty) it.copy(iterations = it.iterations + Training.Exercise.Iteration())
                else it
            }
        )
    }

    private fun Training.provideEmptyIteration(exerciseId: String): Training {
        val exercise = this.exercises.find { it.id == exerciseId } ?: return this
        val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repeat != ""
        if (lastIsNotEmpty.not()) return this
        val newExercise = exercise.copy(iterations = exercise.iterations + Training.Exercise.Iteration())
        val newExercises = this.exercises.map { if (it.id == exerciseId) newExercise else it }
        return this.copy(exercises = newExercises)
    }
}