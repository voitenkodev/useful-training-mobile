package presentation.auth

import Action
import ReduxGroups
import androidx.compose.runtime.Stable

@Stable
internal data class AuthState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)

internal sealed class AuthAction : Action(ReduxGroups.AUTH) {

    data class SetEmailAction(val email: String) : AuthAction()

    data class SetPasswordAction(val password: String) : AuthAction()

    object Validate : AuthAction()

    data class Error(val message: String? = null) : AuthAction()

    data class Loading(val value: Boolean) : AuthAction()
}


//internal val authReducer: ReducerForActionType<AuthState, GlobalState, AuthAction> = { state, _, action ->
//    when (action) {
//        is AuthAction.SetEmailAction -> state.copy(email = action.email)
//        is AuthAction.SetPasswordAction -> state.copy(password = action.password)
//        is AuthAction.Validate -> state.validate()
//        is AuthAction.Error -> state.copy(error = action.message)
//        is AuthAction.Loading -> state.copy(loading = action.value)
//    }
//}

internal fun AuthState.validate(): AuthState {
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