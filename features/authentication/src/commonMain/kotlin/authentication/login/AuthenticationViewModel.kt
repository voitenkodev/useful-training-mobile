package authentication.login

import AuthenticationRepository
import UserRepository
import ViewModel
import authentication.login.models.AuthStatus
import authentication.login.models.ScreenState
import isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import org.koin.core.component.inject

internal class AuthenticationViewModel : ViewModel() {

    private val authApi by inject<AuthenticationRepository>()
    private val userApi by inject<UserRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun login() {
        val last = _state.updateAndGet { it.validate() }

        if (last.error == null) {
            authApi
                .login(last.email, last.password)
                .flatMapConcat { userApi.syncUser() }
                .onStart { _state.update { it.copy(loading = true) } }
                .onEach { _state.update { it.copy(authStatus = AuthStatus.Available, loading = false) } }
                .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
                .launchIn(this)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun markScreenAsShowedOnce() {
        _state.update { it.copy(screenState = ScreenState.ShowedOnce) }
    }

    fun updateEmail(value: String) {
        _state.update { it.copy(email = value) }
    }

    fun updatePassword(value: String) {
        _state.update { it.copy(password = value) }
    }

    private fun State.validate(): State {

        val newEmail = this.email.trim().lowercase()
        val newPassword = this.password.trim()

        val isEmailValid = isEmailValid(newEmail)
        val isPasswordValid = newPassword.length > 5

        val newError = if (isEmailValid.not()) "Invalid Email Field"
        else if (isPasswordValid.not()) "Invalid password field"
        else null

        return this.copy(email = newEmail, password = newPassword, error = newError)
    }
}