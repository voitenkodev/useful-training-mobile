package ui.auth

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import state.AuthState
import ui.navigation.Router

class AuthViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val authSource: AuthSource,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _authState = MutableStateFlow(savedStateHandle["authState"] ?: AuthState.EMPTY)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    init {
        if (authSource.isAuthorized) viewModelScope.launch {
            _navigation.send(Router.Trainings)
        }
    }

    fun login(authState: AuthState) = viewModelScope.launch {
        authSource
            .login(authState.email, authState.password)
            .onEach { _navigation.send(Router.Trainings) }
            .launchIn(this)
    }

    fun registration(authState: AuthState) = viewModelScope.launch {
        authSource
            .registration(authState.email, authState.password)
            .onEach { _navigation.send(Router.Trainings) }
            .launchIn(this)
    }

    fun update(newState: AuthState) {
        _authState.value = newState
        savedStateHandle["trainingState"] = newState
    }
}