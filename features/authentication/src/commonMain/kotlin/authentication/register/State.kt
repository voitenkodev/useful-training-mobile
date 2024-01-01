package authentication.register

import androidx.compose.runtime.Immutable
import authentication.register.models.RegistrationStatus
import authentication.register.models.RegistrationSteps
import weightpicker.DEFAULT_INITIAL_WEIGHT

@Immutable
internal data class State(
    val name: String = "",
    val weight: Int = DEFAULT_INITIAL_WEIGHT,
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