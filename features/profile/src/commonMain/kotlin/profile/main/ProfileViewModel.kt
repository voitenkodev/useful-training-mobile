package profile.main

import AuthenticationRepository
import UserRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import user.mapping.toState

internal class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val userApi by inject<UserRepository>()
    private val authApi by inject<AuthenticationRepository>()

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

    }

    fun logout() {
        launch { authApi.logout() }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}