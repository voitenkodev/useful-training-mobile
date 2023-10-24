package configurations.screen

import ExerciseExamplesRepository
import ViewModel
import configurations.mapping.toState
import configurations.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
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

    init {
        fetchData()
    }

    private fun fetchData() {
        api
            .getExerciseExamples()
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach { r ->
                _state.update {
                    it.copy(exerciseExamples = r.toState())
                }
            }.flatMapConcat {
                api.getMuscles()
            }.onEach { r ->
                _state.update {
                    it.copy(
                        muscles = r.toState(),
                        loading = false
                    )
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun addMuscle() {

    }

    fun addExerciseExample() {

    }

    fun selectMuscle(id: String) {

    }

    fun selectExerciseExample(id: String) {

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