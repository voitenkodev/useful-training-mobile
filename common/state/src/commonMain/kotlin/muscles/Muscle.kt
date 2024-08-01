package muscles

import androidx.compose.runtime.Immutable

@Immutable
public data class Muscle(
    val id: String,
    val name: String,
    val isSelected: Boolean,
    val type: MuscleEnum,

    // dynamic external value
    val load: MuscleLoadEnum?,
)
