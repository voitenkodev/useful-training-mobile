package ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import redux.AuthState
import ui.navigation.Router

class AuthViewModel(
    private val authSource: AuthSource,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _error: Channel<String> = Channel(Channel.BUFFERED)
    val error: Flow<String> = _error.receiveAsFlow()

    init {
        if (authSource.isAuthorized) viewModelScope.launch {
            _navigation.send(Router.Trainings)
        }
    }

    fun login(authState: AuthState) = viewModelScope.launch {
        authSource
            .login(authState.email, authState.password)
            .onEach { _navigation.send(Router.Trainings) }
            .catch { _error.send(it.toString()) }
            .launchIn(this)
    }

    fun registration(authState: AuthState) = viewModelScope.launch {
        authSource
            .registration(authState.email, authState.password)
            .onEach { _navigation.send(Router.Trainings) }
            .launchIn(this)
    }
}