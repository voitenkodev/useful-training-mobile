package authentication.login

import androidx.compose.runtime.Immutable
import authentication.login.models.AuthStatus
import authentication.login.models.ScreenState

@Immutable
internal data class State(
    val screenState: ScreenState = ScreenState.Default,
    val authStatus: AuthStatus = AuthStatus.Unavailable,
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)