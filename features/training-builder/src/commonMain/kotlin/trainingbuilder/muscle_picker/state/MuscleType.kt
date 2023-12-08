package trainingbuilder.muscle_picker.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class MuscleType(
    val id: String,
    val name: String = "",
    val muscles: List<Muscle>,
    val isSelected: Boolean,
    val type: MuscleTypeEnum,
    val bodyImageVector: ImageVector
)

@Immutable
internal enum class MuscleTypeEnum {
    CHEST_MUSCLES,
    BACK_MUSCLES,
    ABDOMINAL_MUSCLES,
    LEGS,
    ARMS_AND_FOREARMS,
    SHOULDER_MUSCLES
}