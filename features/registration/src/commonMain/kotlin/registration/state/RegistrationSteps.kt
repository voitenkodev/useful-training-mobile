package registration.state

import androidx.compose.runtime.Immutable

@Immutable
internal enum class RegistrationSteps {
    Name,
    Weight,
    Height
}