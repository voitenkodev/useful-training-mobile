package redux

import org.reduxkotlin.ReducerForActionType

data class AuthState(
    val email: String = "voitenko.dev@gmail.com",
    val password: String = "bboygasta37373",
    val error: String? = null
)

sealed class AuthAction(action: String) : Action(ReduxGroups.AUTH, action) {

    data class SetEmailAction(val email: String) : AuthAction("SET_EMAIL_ACTION")

    data class SetPasswordAction(val password: String) : AuthAction("SET_PASSWORD_ACTION")

    object LoginAction : AuthAction("LOGIN_ACTION")

    object Validate : AuthAction("VALIDATE_ACTION")

    object RegistrationAction : AuthAction("REGISTRATION_ACTION")
}

val authReducer: ReducerForActionType<AuthState, AuthAction> = { state, action ->
    when (action) {
        is AuthAction.SetEmailAction -> state.copy(email = action.email)
        is AuthAction.SetPasswordAction -> state.copy(password = action.password)
        AuthAction.LoginAction -> TODO()
        AuthAction.RegistrationAction -> TODO()
        AuthAction.Validate -> state.validate()
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

    return if (isEmailValid && isPasswordValid) this.copy(email = newEmail, password = newPassword, error = "")
    else this.copy(error = "Invalid UI")
}