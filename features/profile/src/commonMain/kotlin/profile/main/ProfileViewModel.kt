package profile.main

import AuthenticationRepository
import ExerciseExamplesRepository
import TrainingsRepository
import UserRepository
import ViewModel
import exercise.mapping.toState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import trainings.mapping.toState
import user.mapping.toState

internal class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val userApi by inject<UserRepository>()
    private val authApi by inject<AuthenticationRepository>()
    private val trainingsApi by inject<TrainingsRepository>()
    private val exerciseExamplesApi by inject<ExerciseExamplesRepository>()

    init {
        userApi
            .observeUser()
            .onEach { r -> _state.update { it.copy(user = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        userApi
            .observeLastWeight()
            .onEach { r -> _state.update { it.copy(lastWeight = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        trainingsApi
            .observeLastTraining()
            .onEach { r -> _state.update { it.copy(lastTraining = r?.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        exerciseExamplesApi
            .observeExerciseExamples()
            .onEach { r ->
                _state.update {
                    it.copy(
                        lastExerciseExamples = r.take(2).toState()
                    )
                }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun logout() {
        launch { authApi.logout() }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}