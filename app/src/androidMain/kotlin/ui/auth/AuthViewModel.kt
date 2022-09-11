package ui.auth

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import auth.AuthState
import datasource.AuthSource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AuthViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val authSource: AuthSource,
) : ViewModel() {

    private val _authState = MutableStateFlow(savedStateHandle["authState"] ?: AuthState.EMPTY)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    fun login(authState: AuthState) = viewModelScope.launch {
        authSource
            .login(authState.email, authState.password)
            .onEach { }
            .launchIn(this)
    }

    fun registration(authState: AuthState) = viewModelScope.launch {
        authSource
            .registration(authState.email, authState.password)
            .onEach { }
            .launchIn(this)
    }

    fun update(newState: AuthState) {
        _authState.value = newState
        savedStateHandle["trainingState"] = newState
    }
}