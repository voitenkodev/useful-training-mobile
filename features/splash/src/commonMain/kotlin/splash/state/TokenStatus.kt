package splash.state

import androidx.compose.runtime.Immutable

@Immutable
internal enum class TokenStatus {
    Available, Unavailable, Unknown
}