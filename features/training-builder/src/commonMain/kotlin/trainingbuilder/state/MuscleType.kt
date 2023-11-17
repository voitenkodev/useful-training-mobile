package trainingbuilder.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class MuscleType(
    val id: String,
    val name: String = "",
    val muscles: List<Muscle>,
    val isSelected: Boolean,
    val type: MuscleTypeEnumState,
    val imageVector: ImageVector
)
