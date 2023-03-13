package presentation.auth

import androidx.compose.runtime.Stable

@Stable
internal data class AuthState(
    val email: String = "voitenko.dev@gmai.com",
    val password: String = "qwerty123",
    val error: String? = null,
    val loading: Boolean = false
)