package authentication.register.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val name: String = "",
    val weight: Int = 650,
    val height: Int = 165,
    val email: String = "",
    val password: String = "",
    val passwordRepeat: String = "",

    val selectedStep: RegistrationSteps = RegistrationSteps.Name,
    val steps: List<RegistrationSteps> = RegistrationSteps.entries,

    val registrationStatus: RegistrationStatus = RegistrationStatus.Unavailable,
    val error: String? = null,
    val loading: Boolean = false
)