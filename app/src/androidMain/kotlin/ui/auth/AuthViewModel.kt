package ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import redux.AuthState
import redux.Direction

class AuthViewModel(
    private val authSource: AuthSource,
) : ViewModel() {

    private val _navigation: Channel<Direction> = Channel(Channel.BUFFERED)
    val event: Flow<Direction> = _navigation.receiveAsFlow()

    private val _error: Channel<String> = Channel(Channel.BUFFERED)
    val error: Flow<String> = _error.receiveAsFlow()

    init {
        if (authSource.isAuthorized) viewModelScope.launch {
            _navigation.send(Direction.Trainings)
        }
    }

    fun login(authState: AuthState) = viewModelScope.launch {
        authSource
            .login(authState.email, authState.password)
            .onEach { _navigation.send(Direction.Trainings) }
            .catch { _error.send(it.toString()) }
            .launchIn(this)
    }

    fun registration(authState: AuthState) = viewModelScope.launch {
        authSource
            .registration(authState.email, authState.password)
            .onEach { _navigation.send(Direction.Trainings) }
            .launchIn(this)
    }
}