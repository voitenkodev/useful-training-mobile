package trainingbuilder.screen

import ExerciseExamplesRepository
import TrainingsRepository
import ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import round
import trainingbuilder.mapping.toBody
import trainingbuilder.mapping.toState
import trainingbuilder.state.Exercise
import trainingbuilder.state.Iteration
import trainingbuilder.state.State
import trainingbuilder.state.Training

internal class TrainingViewModel(muscleIds: List<String>) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val trainingsApi by inject<TrainingsRepository>()
    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()

    init {
        exerciseExampleApi
            .observeMusclesById(muscleIds)
            .onEach { r ->
                val list = r.toState()
                _state.update { it.copy(muscles = list, selectedMuscle = list.firstOrNull()) }
            }.catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        exerciseExampleApi.syncMuscleTypes()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    @FlowPreview
    fun saveTraining(onSuccess: (trainingId: String) -> Unit) {
        val training = state.value.training
            .validate()
            .calculateValues()

        if (training.exercises.isEmpty()) {
            _state.update { it.copy(error = "Empty training") }
            return
        }

        trainingsApi.setTraining(training = training.toBody())
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach { r ->
                _state.update { it.copy(loading = false, error = null) }
                onSuccess.invoke(r ?: return@onEach)
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun getTraining(trainingId: String) {
        trainingsApi
            .observeTraining(trainingId = trainingId)
            .onStart {
                _state.update { it.copy(loading = true) }
            }.filterNotNull()
            .onEach { r ->
                _state.update {
                    it.copy(training = r.toState().provideEmptyIterations(), loading = false)
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun removeExercise(exerciseIndex: Int?) {
        exerciseIndex?.let {
            _state.update {
                it.copy(
                    training = it.training.removeExercise(exerciseIndex)
                )
            }
        }
    }

    fun updateName(exerciseIndex: Int, name: String) {
        _state.update {
            it.copy(
                training = it.training.setNameOfExercise(exerciseIndex, name)
            )
        }
    }

    fun updateWeight(exerciseIndex: Int, number: Int, weight: String) {
        _state.update {
            it.copy(
                training = it.training
                    .setWeightOfIteration(exerciseIndex, number, weight)
                    .provideEmptyIteration(exerciseIndex)
            )
        }
    }

    fun updateRepeat(exerciseIndex: Int, number: Int, repeat: String) {
        _state.update {
            it.copy(
                training = it.training
                    .setRepeatOfIteration(exerciseIndex, number, repeat)
                    .provideEmptyIteration(exerciseIndex)
            )
        }
    }

    fun openAddExercisePopup() {
        _state.update {
            val newExercises = (it.training.exercises + Exercise()).toPersistentList()
            val training = it.training.copy(exercises = newExercises)

            it.copy(
                training = training,
                setExercisePopupVisibleIndex = training.exercises.lastIndex
            )
        }
    }

    fun closeSetExercisePopup() {
        _state.update { it.copy(setExercisePopupVisibleIndex = null) }
    }

    fun openFindExercisePopup() {
        _state.update { it.copy(findExercisePopupIsVisibleIndex = true) }
    }

    fun closeFindExercisePopup() {
        _state.update { it.copy(findExercisePopupIsVisibleIndex = false) }
    }

    fun setMuscleTarget(id: String) {
        _state.update {
            it.copy(selectedMuscle = it.muscles.firstOrNull { m -> m.id == id })
        }
    }

    private fun Training.setNameOfExercise(exerciseIndex: Int, name: String): Training {
        return this.copy(
            exercises = this.exercises.mapIndexed { index, item ->
                if (exerciseIndex == index) {
                    item.copy(name = name)
                } else item
            }.toPersistentList()
        )
    }

    private fun Training.setRepeatOfIteration(exerciseIndex: Int, numberOfIteration: Int, repeat: String): Training {
        val exercises = this.exercises.mapIndexed { index, item ->
            if (exerciseIndex != index) {
                item
            } else {
                val iterations = item.iterations.mapIndexedNotNull { iterationIndex, iteration ->
                    val newRepeat = if (numberOfIteration == iterationIndex) repeat else iteration.repetitions
                    if (newRepeat == "" && iteration.weight == "") null
                    else Iteration(weight = iteration.weight, repetitions = newRepeat)
                }.toPersistentList()
                item.copy(iterations = iterations)
            }
        }.toPersistentList()
        return copy(exercises = exercises)
    }

    private fun Training.setWeightOfIteration(exerciseIndex: Int, numberOfIteration: Int, weight: String): Training {
        val exercises = this.exercises.mapIndexed { index, item ->
            if (exerciseIndex != index) {
                item
            } else {
                val iterations = item.iterations.mapIndexedNotNull { iterationIndex, iteration ->
                    val newWeight = if (numberOfIteration == iterationIndex) weight else iteration.weight
                    if (newWeight == "" && iteration.repetitions == "") null
                    else Iteration(weight = newWeight, repetitions = iteration.repetitions)
                }.toPersistentList()
                item.copy(iterations = iterations)
            }
        }.toPersistentList()
        return copy(exercises = exercises)
    }

    private fun Training.removeExercise(exerciseIndex: Int): Training {
        val newList = this.exercises
            .mapIndexedNotNull { index, old -> if (exerciseIndex == index) null else old }
            .toPersistentList()
        return this.copy(exercises = newList)
    }

    private fun Training.validate(): Training {
        val exercises = exercises.mapNotNull {
            val isNameValid = it.name.isNotBlank()
            val iterations = it.iterations.filter { iteration ->
                val repetitions = iteration.repetitions.toIntOrNull()
                val weight = iteration.weight.toDoubleOrNull()
                val isRepeatValid = repetitions != null && repetitions > 0.0
                val isWeightValid = weight != null && weight > 0
                isRepeatValid && isWeightValid
            }.toPersistentList()
            if (isNameValid && iterations.isNotEmpty()) it.copy(iterations = iterations)
            else null
        }.toPersistentList()
        return this.copy(exercises = exercises)
    }

    private fun Training.calculateValues(): Training {
        val calculatedExercises = exercises.map {
            val exVolume = it.iterations.sumOf { iteration ->
                (iteration.repetitions.toIntOrNull() ?: 0) * (iteration.weight.toDoubleOrNull() ?: 0.0)
            }
            val exRepetitions = it.iterations.sumOf { iteration ->
                iteration.repetitions.toIntOrNull() ?: 0
            }
            val exIntensity = (exVolume / exRepetitions)
            it.copy(
                volume = exVolume.round(2),
                repetitions = exRepetitions,
                intensity = exIntensity.round(1)
            )
        }.toPersistentList()

        val trainVolume = calculatedExercises.sumOf { it.volume }
        val trainRepetitions = calculatedExercises.sumOf { it.repetitions }
        val trainIntensity = trainVolume / trainRepetitions

        return this.copy(
            exercises = calculatedExercises,
            volume = trainVolume.round(2),
            repetitions = trainRepetitions,
            intensity = trainIntensity.round(1)
        )
    }

    private fun Training.provideEmptyIterations(): Training {
        return this.copy(
            exercises = exercises.map {
                val lastIsNotEmpty = it.iterations.lastOrNull()?.weight != "" || it.iterations.lastOrNull()?.repetitions != ""
                if (lastIsNotEmpty) it.copy(iterations = (it.iterations + Iteration()).toPersistentList())
                else it
            }.toPersistentList()
        )
    }

    private fun Training.provideEmptyIteration(exerciseIndex: Int): Training {
        val exercise = this.exercises.getOrNull(exerciseIndex) ?: return this
        val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repetitions != ""
        if (lastIsNotEmpty.not()) return this
        val newExercise = exercise.copy(iterations = (exercise.iterations + Iteration()).toPersistentList())
        val newExercises = this.exercises
            .mapIndexed { index, item -> if (index == exerciseIndex) newExercise else item }
            .toPersistentList()
        return this.copy(exercises = newExercises)
    }
}