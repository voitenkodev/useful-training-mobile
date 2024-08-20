package muscles.component

import IncludedStatusEnum
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import muscles.Muscle

@Composable
public fun MuscleChip(
    loadingById: String? = null,
    muscle: Muscle,
    selectMuscle: (id: String) -> Unit
) {

    val contentColor = remember(muscle.isSelected) {
        when {
            muscle.status == IncludedStatusEnum.EXCLUDED -> Design.palette.content.copy(alpha = 0.3f)
            muscle.isSelected.not() -> Design.palette.content
            muscle.isSelected -> Design.palette.content
            else -> Design.palette.content
        }
    }

    val coverage = muscle.coverage

    val backgroundColor = when {
        coverage != null && coverage.percentage != 0 -> coverage.color
        muscle.status == IncludedStatusEnum.EXCLUDED -> Design.palette.secondary
        muscle.isSelected -> Design.palette.green
        muscle.isSelected.not() -> Design.palette.tertiary
        else -> Design.palette.tertiary
    }

    val chipState = ChipState.Colored(
        backgroundColor = backgroundColor,
        borderColor = Color.Transparent,
        contentColor = contentColor
    )

    val muscleName = remember(muscle.name, muscle.coverage) {
        buildString {
            if (muscle.coverage != null && muscle.coverage.percentage != 0) {
                append(muscle.coverage.percentage)
                append("% ")
            }
            append(muscle.name)
        }
    }
    Chip(
        chipState = chipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        text = muscleName,
        loading = loadingById == muscle.id,
    )
}