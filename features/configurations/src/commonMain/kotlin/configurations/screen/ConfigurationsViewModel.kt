package configurations.screen

import ExerciseExamplesRepository
import ViewModel
import configurations.mapping.toState
import configurations.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
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
        api.observeExerciseExamples()
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach { r ->
                _state.update { it.copy(exerciseExamples = r.toState()) }
            }.flatMapLatest {
                api.observeMuscles()
            }.onEach { r ->
                _state.update { it.copy(muscles = r.toState(), loading = false) }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)

        api.syncExerciseExamples()
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)

        api
            .syncMuscles()
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}