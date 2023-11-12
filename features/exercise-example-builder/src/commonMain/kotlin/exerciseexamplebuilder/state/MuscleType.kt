package exerciseexamplebuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class MuscleType(
    val id: String,
    val name: String
)