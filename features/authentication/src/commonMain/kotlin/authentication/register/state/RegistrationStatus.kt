package authentication.register.state

import androidx.compose.runtime.Immutable

@Immutable
internal enum class RegistrationStatus {
    Available,
    Unavailable
}