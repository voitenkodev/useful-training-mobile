package authentication

import androidx.compose.runtime.Immutable

@Immutable
data class AuthenticationState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)