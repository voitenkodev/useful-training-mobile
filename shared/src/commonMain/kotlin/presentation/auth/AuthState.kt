package presentation.auth

import androidx.compose.runtime.Immutable

@Immutable
internal data class AuthState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)