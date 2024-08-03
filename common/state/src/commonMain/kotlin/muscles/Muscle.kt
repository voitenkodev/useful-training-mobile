package muscles

import IncludedStatusEnum
import androidx.compose.runtime.Immutable

@Immutable
public data class Muscle(
    val id: String,
    val name: String,
    val isSelected: Boolean,
    val type: MuscleEnum,

    // by user
    val status: IncludedStatusEnum?,

    // dynamic external value
    val load: MuscleLoadEnum?,
)
