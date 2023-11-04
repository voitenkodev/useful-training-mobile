package authentication.screen

import AuthenticationRepository
import ViewModel
import authentication.state.State
import authentication.state.TokenStatus
import isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class AuthenticationViewModel : ViewModel() {

    private val api by inject<AuthenticationRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        subscribeToken()
    }

    private fun subscribeToken() {
        api
            .getToken()
            .filterNotNull()
            .onEach { _state.update { it.copy(tokenStatus = TokenStatus.Available) } }
            .launchIn(this)
    }

    fun login() {
        _state.update { it.validate() }

        if (state.value.error == null) {
            api.login(state.value.email, state.value.password)
                .onStart { _state.update { it.copy(loading = true) } }
                .onEach { _state.update { it.copy(loading = false) } }
                .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
                .launchIn(this)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
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