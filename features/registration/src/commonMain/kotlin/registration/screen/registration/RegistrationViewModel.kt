package registration.screen.registration

import AuthenticationRepository
import UserRepository
import ViewModel
import isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import registration.state.RegistrationStatus
import registration.state.State

internal class RegistrationViewModel : ViewModel() {

    private val authApi by inject<AuthenticationRepository>()
    private val userApi by inject<UserRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state

    init {
        subscribeToken()
    }

    private fun subscribeToken() {
        authApi
            .getToken()
            .filterNotNull()
            .onEach { _state.update { it.copy(registrationStatus = RegistrationStatus.Available) } }
            .launchIn(this)
    }

    fun registration() {
        _state.update { it.validate() }

        if (state.value.error == null) {
            authApi
                .registration(
                    email = state.value.email,
                    password = state.value.password,
                    name = state.value.name,
                    weight = state.value.weight,
                    height = state.value.height
                )
                .flatMapConcat { userApi.syncUser() }
                .onStart { _state.update { it.copy(loading = true) } }
                .onEach { _state.update { it.copy(registrationStatus = RegistrationStatus.Available, loading = false) } }
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

    fun updateName(value: String) {
        _state.update { it.copy(name = value) }
    }

    fun updatePassword(value: String) {
        _state.update { it.copy(password = value) }
    }

    fun updatePasswordRepeat(value: String) {
        _state.update { it.copy(passwordRepeat = value) }
    }

    fun updateWeight(value: Int) {
        _state.update { it.copy(weight = value) }
    }

    fun updateHeight(value: Int) {
        _state.update { it.copy(height = value) }
    }

    fun previousStep(onNextEmpty: () -> Unit) {
        _state.update {
            val newStepIndex = it.steps.indexOf(it.selectedStep).minus(1)
            if (newStepIndex < 0) {
                onNextEmpty.invoke()
                it
            } else it.copy(selectedStep = it.steps[newStepIndex])
        }
    }

    fun nextStep() {
        _state.update {
            val newStepIndex = it.steps.indexOf(it.selectedStep).plus(1)
            if (newStepIndex > it.steps.lastIndex) it
            else it.copy(selectedStep = it.steps[newStepIndex])
        }
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