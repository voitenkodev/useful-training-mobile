package muscles

import IncludedStatusEnum
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
public data class Muscle(
    val id: String,
    val name: String,
    val type: MuscleEnum,

    // by user
    val status: IncludedStatusEnum?,

    // dynamic external value
    val isSelected: Boolean,
    val load: MuscleLoadEnum?,
    val coverage: Coverage? = null,
)

@Immutable
public data class Coverage(
    val color: Color,
    val percentage: Int
)