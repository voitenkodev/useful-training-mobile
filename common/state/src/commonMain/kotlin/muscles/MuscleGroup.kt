package muscles

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
public data class MuscleGroup(
    val id: String,
    val name: String = "",
    val muscles: List<Muscle>, // todo mov persistent
    val isSelected: Boolean,
    val type: MuscleGroupEnum,
    val bodyImageVector: ImageVector
)