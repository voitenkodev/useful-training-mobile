package trainingbuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class MuscleType(
    val id: String,
    val name: String = "",
    val muscles: List<Muscle>,
    val isSelected: Boolean,
    val type: MuscleTypeEnum
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