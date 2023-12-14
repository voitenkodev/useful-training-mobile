package authentication.register.models

import androidx.compose.runtime.Immutable

@Immutable
internal enum class RegistrationStatus {
    Available,
    Unavailable
}