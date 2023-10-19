package authentication.screen

import AuthRepository
import ViewModel
import authentication.state.State
import isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import org.koin.core.component.inject

internal class AuthenticationViewModel : ViewModel() {

    private val api by inject<AuthRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state

    fun subscribeToken(onReceive: () -> Unit) {
        api
            .getToken()
            .filterNotNull()
            .onEach {
                _state.value = state.value.copy(loading = false, error = null)
                onReceive.invoke()
            }
            .launchIn(this)
    }

    fun login() {
        _state.value = state.value.validate()

        if (state.value.error == null) {
            api.login(state.value.email, state.value.password)
                .onStart {
                    _state.value = state.value.copy(loading = true)
                }.catch {
                    _state.value = state.value.copy(loading = false, error = it.message)
                }.launchIn(this)
        }
    }

    fun registration() {
        _state.value = state.value.validate()

        if (state.value.error == null) {
            api.registration(state.value.email, state.value.password)
                .onStart {
                    _state.value = state.value.copy(loading = true)
                }.catch {
                    _state.value = state.value.copy(loading = false, error = it.message)
                }.launchIn(this)
        }
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun updateEmail(value: String) {
        _state.value = state.value.copy(email = value)
    }

    fun updatePassword(value: String) {
        _state.value = state.value.copy(password = value)
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