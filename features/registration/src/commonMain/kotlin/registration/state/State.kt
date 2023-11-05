package registration.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val name: String = "asd",
    val weight: Int = 650,
    val height: Int = 400,
    val email: String = "",
    val password: String = "",

    val selectedStep: RegistrationSteps = RegistrationSteps.Name,
    val steps: List<RegistrationSteps> = RegistrationSteps.entries,

    val tokenStatus: TokenStatus = TokenStatus.Unavailable,
    val error: String? = null,
    val loading: Boolean = false
)