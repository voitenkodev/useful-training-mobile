package profile.screen

import AuthenticationRepository
import UserRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import profile.mapping.toState
import profile.state.State

internal class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val userApi by inject<UserRepository>()
    private val authApi by inject<AuthenticationRepository>()

    init {
        userApi
            .observeUser()
            .onEach { r -> _state.update { it.copy(user = r.toState()) } }
            .launchIn(this)
    }

    fun logout() {
        launch { authApi.logout() }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}