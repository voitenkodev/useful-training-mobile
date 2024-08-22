package muscles.component

import IncludedStatusEnum
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import molecule.IconImage
import molecule.PaddingS
import muscles.Muscle
import muscles.MuscleLoadEnum
import resources.Icons

// to show some additional parts of UI
@Immutable
public enum class ComponentVisible { LOADING }

@Composable
public fun MuscleChip(
    loadingById: String? = null,
    muscle: Muscle,
    semiFields: ImmutableList<ComponentVisible>,
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

    val icon = remember(muscle.load, semiFields) {
        if (semiFields.contains(ComponentVisible.LOADING).not()) return@remember null
        if (muscle.status == IncludedStatusEnum.EXCLUDED) return@remember null
        return@remember when (muscle.load) {
            MuscleLoadEnum.HIGH -> Icons.highBattery
            MuscleLoadEnum.MEDIUM -> Icons.mediumBattery
            MuscleLoadEnum.LOW -> Icons.lowBattery
            null -> null
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

    Row(verticalAlignment = Alignment.CenterVertically) {
        if (icon != null) {
            IconImage(
                modifier = Modifier.size(Design.dp.iconXS),
                imageVector = icon
            )

            PaddingS()
        }

        Chip(
            chipState = chipState,
            onClick = { selectMuscle.invoke(muscle.id) },
            text = muscleName,
            loading = loadingById == muscle.id,
        )
    }
}