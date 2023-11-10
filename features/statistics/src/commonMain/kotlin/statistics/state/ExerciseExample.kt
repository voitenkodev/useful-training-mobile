package statistics.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class ExerciseExample(
    val id: String,
    val name: String = "",
    val isSelected: Boolean = false
)