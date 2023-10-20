package trainingbuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class Iteration(
    val weight: String = "",
    val repeat: String = ""
)