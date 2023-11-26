package exerciseexamplebuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class ExerciseExample(
    val id: String? = null,
    val name: String = ""
)