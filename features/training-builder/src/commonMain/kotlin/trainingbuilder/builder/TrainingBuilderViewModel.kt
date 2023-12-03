package trainingbuilder.builder

import ExerciseExamplesRepository
import TrainingsRepository
import ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import round
import trainingbuilder.builder.mapping.toBody
import trainingbuilder.builder.mapping.toState
import trainingbuilder.builder.state.Exercise
import trainingbuilder.builder.state.State
import trainingbuilder.builder.state.Training

internal class TrainingBuilderViewModel(muscleIds: List<String>) : ViewModel() {

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

        exerciseExampleApi
            .observeExerciseExamples()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { r -> _state.update { it.copy(loading = false, exerciseExamples = r.toState()) } }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
            .launchIn(this)

        exerciseExampleApi
            .syncMuscleTypes()
            .flatMapConcat { exerciseExampleApi.syncExerciseExamples() }
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
                    it.copy(
                        training = r.toState(),
                        loading = false
                    )
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun saveExercise(index: Int, exercise: Exercise) {
        _state.update {
            val exercises = if (index in 0..it.training.exercises.lastIndex)
                it.training.exercises.set(index, exercise)
            else buildList {
                addAll(it.training.exercises)
                add(exercise)
            }.toPersistentList()

            val training = it.training.copy(exercises = exercises)

            it.copy(training = training)
        }
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

    fun openAddExercisePopup() {
        openSetExercisePopup(state.value.training.exercises.lastIndex + 1)
    }

    fun openSetExercisePopup(index: Int) {
        _state.update { it.copy(setExercisePopupVisibleIndex = index) }
    }

    fun closeSetExercisePopup() {
        _state.update { it.copy(setExercisePopupVisibleIndex = -1) }
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
}