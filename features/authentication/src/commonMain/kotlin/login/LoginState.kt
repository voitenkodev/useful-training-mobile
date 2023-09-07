package login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)