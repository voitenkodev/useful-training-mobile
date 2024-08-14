package muscles.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import muscles.Muscle
import resources.Icons

@Composable
public fun MuscleChip(
    loadingById: String? = null,
    muscle: Muscle,
    selectMuscle: (id: String) -> Unit
) {

    val contentColor = remember(muscle.isSelected) {
        when (muscle.isSelected) {
            false -> Design.palette.content.copy(alpha = 0.3f)
            true -> Design.palette.content
        }
    }

    val borderColor =
        muscle.coverage?.color
            .takeIf { muscle.coverage?.percentage != 0 }
            ?: if (muscle.isSelected) {
                Design.palette.green.copy(alpha = 0.4f)
            } else {
                Design.palette.white10
            }

    val chipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = borderColor,
        contentColor = contentColor
    )

    val iconStart = remember(muscle.isSelected) {
        when (muscle.isSelected) {
            false -> Icons.checkOff
            true -> Icons.checkOn
        }
    }

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
        iconStart = iconStart
    )
}