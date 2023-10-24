package configurations.screen

import ExerciseExamplesRepository
import ViewModel
import configurations.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import models.ExerciseExample
import models.Muscle
import org.koin.core.component.inject

internal class ConfigurationsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    fun getExerciseExamples() {
        api
            .getExerciseExamples()
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach {
                _state.update {
                    it.copy()
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun getMuscleWithExerciseExamplesById(muscleId: Long) {

    }

    fun setExerciseExampleWithMuscles(exerciseExample: ExerciseExample, muscles: List<Muscle>) {

    }

    fun setMuscleWithExerciseExamples(muscle: Muscle, exerciseExamples: List<ExerciseExample>) {

    }


    fun clearError() {
        _state.update { it.copy(error = null) }
    }

}