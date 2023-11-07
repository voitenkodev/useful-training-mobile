package authentication.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val screenState: ScreenState = ScreenState.Default,
    val authStatus: AuthStatus = AuthStatus.Unavailable,
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)