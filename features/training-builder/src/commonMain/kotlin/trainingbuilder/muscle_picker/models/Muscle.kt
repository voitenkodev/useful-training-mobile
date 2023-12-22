package trainingbuilder.muscle_picker.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class Muscle(
    val id: String,
    val name: String,
    val priority: PriorityEnum,
    val isSelected: Boolean,
    val type: MuscleEnum
)

