package authentication.register.state

import androidx.compose.runtime.Immutable

@Immutable
internal enum class RegistrationSteps {
    Name,
    Weight,
    Height,
    EmailPassword
}