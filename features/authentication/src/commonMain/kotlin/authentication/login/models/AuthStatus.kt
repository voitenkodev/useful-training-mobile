package authentication.login.models

import androidx.compose.runtime.Immutable

@Immutable
internal enum class AuthStatus {
    Available,
    Unavailable
}