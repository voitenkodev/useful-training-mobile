package configurations.screen

import ExerciseExamplesRepository
import ViewModel
import configurations.mapping.toDomain
import configurations.mapping.toState
import configurations.popups.ExerciseExampleState
import configurations.popups.MusclePopupState
import configurations.state.ExerciseExample
import configurations.state.Muscle
import configurations.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class ConfigurationsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    init {
        fetchData()
    }

    private fun fetchData() {
        api
            .getExerciseExamples()
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach { r ->
                _state.update { it.copy(exerciseExamples = r.toState()) }
            }.flatMapLatest {
                api.getMuscles()
            }.onEach { r ->
                _state.update { it.copy(muscles = r.toState(), loading = false) }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun addMuscle() {
        _state.update {
            it.copy(
                musclePopupState = MusclePopupState.CREATE(
                    allExerciseExamples = it.exerciseExamples
                )
            )
        }
    }

    fun addExerciseExample() {
        _state.update {
            it.copy(
                exerciseExamplePopupState = ExerciseExampleState.CREATE(
                    allMuscles = it.muscles
                )
            )
        }
    }

    fun selectMuscle(muscleId: String) {
        api.getMuscleWithExerciseExamplesById(muscleId)
            .filterNotNull()
            .onEach { r ->
                _state.update {
                    it.copy(
                        musclePopupState = MusclePopupState.UPDATE(
                            muscle = r.first.toState(),
                            allExerciseExamples = it.exerciseExamples,
                            appliedExerciseExamples = r.second.toState()
                        )
                    )
                }
            }.launchIn(this)

    }

    fun selectExerciseExample(exerciseExampleId: String) {
        api.getExerciseExampleWithMusclesById(exerciseExampleId)
            .filterNotNull()
            .onEach { r ->
                _state.update {
                    it.copy(
                        exerciseExamplePopupState = ExerciseExampleState.UPDATE(
                            exerciseExample = r.first.toState(),
                            allMuscles = it.muscles,
                            appliedMuscles = r.second.toState()
                        )
                    )
                }
            }.launchIn(this)
    }

    fun setExerciseExampleWithMuscles(exerciseExample: ExerciseExample, muscles: List<Muscle>) {
        closePopups()
        api.setExerciseExampleWithMuscles(
            exerciseExample = exerciseExample.toDomain(),
            muscles = muscles.toDomain()
        )
    }

    fun setMuscleWithExerciseExamples(muscle: Muscle, exerciseExamples: List<ExerciseExample>) {
        closePopups()
        api.setMuscleWithExerciseExamples(
            muscle = muscle.toDomain(),
            exerciseExamples = exerciseExamples.toDomain()
        )
    }

    fun closePopups() {
        _state.update {
            it.copy(
                musclePopupState = null,
                exerciseExamplePopupState = null
            )
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}