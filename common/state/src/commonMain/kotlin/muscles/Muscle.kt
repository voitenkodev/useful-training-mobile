package muscles

import androidx.compose.runtime.Immutable

@Immutable
public data class Muscle(
    val id: String,
    val name: String,
    val status: MuscleStatusEnum,
    val isSelected: Boolean,
    val type: MuscleEnum
)

