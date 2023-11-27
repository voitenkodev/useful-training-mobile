package authentication.login.state

import androidx.compose.runtime.Immutable

@Immutable
internal enum class AuthStatus {
    Available,
    Unavailable
}