package profile.screen

import AuthenticationRepository
import ExerciseExamplesRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import profile.mapping.toState
import profile.state.State

internal class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()
    private val authApi by inject<AuthenticationRepository>()

    init {
        exerciseExampleApi.observeExerciseExamples()
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach { r ->
                _state.update { it.copy(exerciseExamples = r.toState()) }
            }.flatMapLatest {
                exerciseExampleApi.observeMuscles()
            }.onEach { r ->
                _state.update { it.copy(muscles = r.toState(), loading = false) }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)

        exerciseExampleApi.syncExerciseExamples()
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)

        exerciseExampleApi
            .syncMuscles()
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)
    }

    fun logout() {
        launch { authApi.logout() }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}