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
