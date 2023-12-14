package authentication.splash.models

import androidx.compose.runtime.Immutable

@Immutable
internal enum class TokenStatus {
    Available,
    Unavailable,
    Unknown
}