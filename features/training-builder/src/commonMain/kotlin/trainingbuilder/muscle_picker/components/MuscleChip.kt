package trainingbuilder.muscle_picker.components

import androidx.compose.runtime.Composable
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import trainingbuilder.muscle_picker.models.Muscle
import trainingbuilder.muscle_picker.models.PriorityEnum

@Composable
internal fun MuscleChip(
    muscle: Muscle,
    selectMuscle: (id: String) -> Unit
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.toxic.copy(alpha = 0.2f),
        borderColor = Design.colors.toxic,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = when (muscle.priority) {
        is PriorityEnum.High -> ChipState.Animated(
            backgroundColor = Design.colors.primary,
            borderColors = muscle.priority.borderColors,
            contentColor = muscle.priority.textColor
        )

        is PriorityEnum.Low -> ChipState.Colored(
            backgroundColor = Design.colors.primary,
            borderColor = muscle.priority.borderColor,
            contentColor = muscle.priority.textColor
        )

        is PriorityEnum.Medium -> ChipState.Colored(
            backgroundColor = Design.colors.primary,
            borderColor = muscle.priority.borderColor,
            contentColor = muscle.priority.textColor
        )
    }

    Chip(
        chipState = if (muscle.isSelected) selectedChipState else unSelectedChipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        text = muscle.name
    )
}