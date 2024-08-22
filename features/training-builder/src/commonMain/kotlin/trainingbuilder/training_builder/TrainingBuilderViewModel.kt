package trainingbuilder.training_builder

import ExerciseExamplesRepository
import MusclesRepository
import TrainingsRepository
import ViewModel
import exercise.ExerciseExample
import exercise.mapping.toState
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import muscles.mapping.toState
import org.koin.core.component.inject
import round
import trainingbuilder.training_builder.factories.createFrontBackImages
import trainingbuilder.training_builder.mapping.toBody
import trainingbuilder.training_builder.models.BuildExercise
import trainingbuilder.training_builder.models.BuildTraining
import trainingbuilder.training_builder.models.SetExerciseState

internal class TrainingBuilderViewModel(muscleIds: List<String>) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val trainingsApi by inject<TrainingsRepository>()
    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()
    private val musclesApi by inject<MusclesRepository>()

    init {
        musclesApi
            .observeMusclesById(muscleIds)
            .map { it.mapNotNull { it.toState(isSelected = false) } }
            .onEach { r ->
                _state.update {
                    it.copy(
                        muscles = r.toPersistentList(),
                        selectedMuscle = r.firstOrNull()
                    )
                }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        _state
            .mapLatest { it.selectedMuscle }
            .flatMapLatest { muscle ->
                _state.map { it.buildTraining.buildExercises }.map { muscle to it }
            }
            .distinctUntilChanged()
            .flatMapLatest {
                exerciseExampleApi
                    .getExerciseExamples(1, 10)
                    .onStart { _state.update { it.copy(recommendationsLoading = true) } }
                    .catch { t ->
                        _state.update {
                            it.copy(
                                recommendationsLoading = false,
                                error = t.message
                            )
                        }
                    }.onEach { r ->
                        _state.update {
                            it.copy(
                                recommendationsLoading = false,
                                exerciseExamples = r.toState()
                            )
                        }
                    }
//            }.flatMapLatest {
//                exerciseExampleApi.getRecommendedExerciseExamples(
//                    page = 1,
//                    size = 10,
//                    targetMuscleId = it.first?.id,
//                    exerciseCount = it.second.size,
//                    exerciseExampleIds = it.second.mapNotNull { it.exerciseExample?.id }
//                ).onStart { _state.update { it.copy(recommendationsLoading = true) } }
//                    .catch { t ->
//                        _state.update {
//                            it.copy(
//                                recommendationsLoading = false,
//                                error = t.message
//                            )
//                        }
//                    }
//                    .onEach { r ->
//                        _state.update {
//                            it.copy(
//                                recommendationsLoading = false,
//                                exerciseExamples = r.toState()
//                            )
//                        }
//                    }
            }.launchIn(this)
    }

    fun saveTraining(onSuccess: (trainingId: String) -> Unit) {
        val training = state.value.buildTraining
            .validate()
            .calculateValues()

        if (training.buildExercises.isEmpty()) {
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

    fun saveExercise(buildExercise: BuildExercise) {
        val index = (state.value.setExerciseState as? SetExerciseState.Opened)?.index ?: -1

        _state.update {
            val exercises = if (index in 0..it.buildTraining.buildExercises.lastIndex)
                it.buildTraining.buildExercises.set(index, buildExercise)
            else buildList {
                addAll(it.buildTraining.buildExercises)
                add(buildExercise)
            }.toPersistentList()

            val training = it.buildTraining.copy(buildExercises = exercises)
                .validate()
                .calculateValues()

            val images = training.buildExercises
                .createFrontBackImages()

            it.copy(
                buildTraining = training,
                fullFrontImageVector = images.first,
                fullBackImageVector = images.second
            )
        }
    }

    fun removeExercise(exerciseIndex: Int?) {
        exerciseIndex?.let {
            _state.update { it.copy(buildTraining = it.buildTraining.removeExercise(exerciseIndex)) }
        }
    }

    fun getExerciseExampleById(id: String) {
        launch {
            val result = exerciseExampleApi
                .observeExerciseExample(id)
                .onStart { _state.update { it.copy(loading = true) } }
                .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
                .onEach { _state.update { it.copy(loading = false) } }
                .firstOrNull()
                ?.toState() ?: return@launch

            closeFindExercisePopup()
            openAddExercise(result)
        }
    }

    fun openAddExercise(index: Int, exerciseExample: ExerciseExample? = null) {
        _state.update {
            it.copy(
                setExerciseState = SetExerciseState.Opened(
                    index = index,
                    exerciseExample = exerciseExample
                )
            )
        }
    }

    fun openAddExercise(exerciseExample: ExerciseExample? = null) {
        val newIndex = state.value.buildTraining.buildExercises.lastIndex + 1

        _state.update {
            it.copy(
                setExerciseState = SetExerciseState.Opened(
                    index = newIndex,
                    exerciseExample = exerciseExample
                )
            )
        }
    }

    fun closeSetExercise() {
        _state.update {
            it.copy(setExerciseState = SetExerciseState.Closed)
        }
    }

    fun openFindExercisePopup() {
        _state.update { it.copy(findExercisePopupIsVisible = true) }
    }

    fun closeFindExercisePopup() {
        _state.update { it.copy(findExercisePopupIsVisible = false) }
    }

    fun setMuscleTarget(id: String) {
        _state.update {
            it.copy(selectedMuscle = it.muscles.firstOrNull { m -> m.id == id })
        }
    }

    private fun BuildTraining.removeExercise(exerciseIndex: Int): BuildTraining {
        val newList = this.buildExercises
            .mapIndexedNotNull { index, old -> if (exerciseIndex == index) null else old }
            .toPersistentList()
        return this.copy(buildExercises = newList)
    }

    private fun BuildTraining.validate(): BuildTraining {
        val exercises = buildExercises.mapNotNull {
            val isNameValid = it.name.isNotBlank()
            val iterations = it.buildIterations.filter { iteration ->
                val repetitions = iteration.repetitions.toIntOrNull()
                val weight = iteration.weight.toDoubleOrNull()
                val isRepeatValid = repetitions != null && repetitions > 0.0
                val isWeightValid = weight != null && weight > 0
                isRepeatValid && isWeightValid
            }.toPersistentList()
            if (isNameValid && iterations.isNotEmpty()) it.copy(buildIterations = iterations)
            else null
        }.toPersistentList()
        return this.copy(buildExercises = exercises)
    }

    private fun BuildTraining.calculateValues(): BuildTraining {
        val calculatedExercises = buildExercises.map {
            val exVolume = it.buildIterations.sumOf { iteration ->
                (iteration.repetitions.toIntOrNull() ?: 0) * (iteration.weight.toDoubleOrNull()
                    ?: 0.0)
            }
            val exRepetitions = it.buildIterations.sumOf { iteration ->
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
            buildExercises = calculatedExercises,
            volume = trainVolume.round(2),
            repetitions = trainRepetitions,
            intensity = trainIntensity.round(1)
        )
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}