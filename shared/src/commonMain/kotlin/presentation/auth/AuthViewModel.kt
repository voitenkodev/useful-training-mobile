package presentation.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class AuthViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    fun login(email: String, password: String) = viewModelScope.launch {
        _state.value = state.value.validate()
//        api.login(email, password)
//            .onStart {
////                dispatcher(AuthAction.Loading(true))
//            }.onEach {
////                dispatcher(AuthAction.Loading(false))
////                dispatcher(AuthAction.Error(null))
////                navigator.navigate(Graph.Trainings.link, true)
//            }.catch {
////                dispatcher(AuthAction.Loading(false))
////                dispatcher(AuthAction.Error(it.message))
//            }.launchIn(this)
    }

    fun registration(
        email: String,
        password: String,
    ) = viewModelScope.launch {
//        api.registration(email, password)
//            .onStart {
////                dispatcher(AuthAction.Loading(true))
//            }.onEach {
////                dispatcher(AuthAction.Loading(false))
////                dispatcher(AuthAction.Error(null))
//                navigator.navigate(Graph.Trainings.link, true)
//            }.catch {
////                dispatcher(AuthAction.Loading(false))
////                dispatcher(AuthAction.Error(it.message))
//            }.launchIn(this)
    }

    fun back() {
        navigator.back()
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

    private fun AuthState.validate(): AuthState {
        val emailAddressRegex = Regex(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"
                    + ")+"
        )

        val newEmail = this.email.trim()
        val newPassword = this.password.trim()

        val isEmailValid = newEmail.matches(emailAddressRegex)
        val isPasswordValid = newPassword.length > 5

        val newError = if (isEmailValid.not()) "Invalid Email Field"
        else if (isPasswordValid.not()) "Invalid password field"
        else null

        return this.copy(email = newEmail, password = newPassword, error = newError)
    }
}