package authentication

import AuthRepository
import ViewModel
import isEmailValid
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class AuthenticationViewModel : ViewModel() {

    private val api by inject<AuthRepository>()

    private val _state = MutableStateFlow(AuthenticationState())
    val state: StateFlow<AuthenticationState> = _state

    fun subscribeToken(onReceive: () -> Unit) {
        launch {
            api
                .getToken()
                .filterNotNull()
                .onEach {
                    onReceive.invoke()
                    delay(100) // TODO IT WILL FIX WITH NEW NAVIGATION
                    _state.value = state.value.copy(loading = false, error = null)
                }
                .launchIn(this)
        }
    }

    fun login() {
        launch {
            _state.value = state.value.validate()

            if (state.value.error == null) api.login(state.value.email, state.value.password)
                .onStart {
                    _state.value = state.value.copy(loading = true)
                }.catch {
                    _state.value = state.value.copy(loading = false, error = it.message)
                }.launchIn(this)
        }
    }

    fun registration() {
        launch {
            _state.value = state.value.validate()

            if (state.value.error == null) api.registration(state.value.email, state.value.password)
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

    private fun AuthenticationState.validate(): AuthenticationState {

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