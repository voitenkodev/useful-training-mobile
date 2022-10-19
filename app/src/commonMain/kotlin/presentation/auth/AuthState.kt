package presentation.auth

import Action
import GlobalState
import ReducerForActionType
import ReduxGroups

data class AuthState(
    val email: String = "voitenko.dev@gmail.",
    val password: String = "bboygasta37373",
    val error: String? = null,
    val loading: Boolean = false
)

sealed class AuthAction(action: String) : Action(ReduxGroups.AUTH, action) {

    data class SetEmailAction(val email: String) : AuthAction("SET_EMAIL_ACTION")

    data class SetPasswordAction(val password: String) : AuthAction("SET_PASSWORD_ACTION")

    object Validate : AuthAction("VALIDATE_ACTION")
    data class Error(val message: String? = null) : AuthAction("ERROR_ACTION")
    data class Loading(val value: Boolean) : AuthAction("LOADING_ACTION")
}


val authReducer: ReducerForActionType<AuthState, GlobalState, AuthAction> = { state, _, action ->
    when (action) {
        is AuthAction.SetEmailAction -> state.copy(email = action.email)
        is AuthAction.SetPasswordAction -> state.copy(password = action.password)
        is AuthAction.Validate -> state.validate()
        is AuthAction.Error -> state.copy(error = action.message)
        is AuthAction.Loading -> state.copy(loading = action.value)
    }
}

fun AuthState.validate(): AuthState {
    val emailAddressRegex = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
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