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

    val chipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.palette.white10,
        contentColor = contentColor
    )

    val iconStart = remember(muscle.isSelected) {
        when (muscle.isSelected) {
            false -> Icons.checkOff
            true -> Icons.checkOn
        }
    }

    Chip(
        chipState = chipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        text = muscle.name,
        loading = loadingById == muscle.id,
        iconStart = iconStart
    )
}