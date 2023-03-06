package presentation.auth

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class AuthViewModel(
    private val navigator: NavigatorCore,
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state

    init {
        viewModelScope.launch {
//            if (api.isAuthorized) navigator.navigate(Graph.Trainings.link, true)
        }
    }

    fun login(
        email: String,
        password: String,
    ) = viewModelScope.launch {
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

    fun validate(): AuthState {
        val emailAddressRegex = Regex(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        val newEmail = state.value.email.trim()
        val newPassword = state.value.password.trim()

        val isEmailValid = newEmail.matches(emailAddressRegex)
        val isPasswordValid = newPassword.length > 5

        val newError = if (isEmailValid.not()) "Invalid Email Field"
        else if (isPasswordValid.not()) "Invalid password field"
        else null

        return state.value.copy(email = newEmail, password = newPassword, error = newError)
    }
}