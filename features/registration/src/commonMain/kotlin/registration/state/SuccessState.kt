package registration.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class SuccessState(
    val name: String = "",
    val height: String = "",
    val weight: String = ""
)