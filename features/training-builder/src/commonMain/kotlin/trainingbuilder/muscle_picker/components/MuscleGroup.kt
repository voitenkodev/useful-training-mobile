package trainingbuilder.muscle_picker.components

import IncludedStatusEnum
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextH4
import muscles.Muscle
import muscles.MuscleGroup
import muscles.MuscleLoadEnum
import resources.Icons

@Composable
internal fun MuscleGroup(
    item: MuscleGroup,
    includedMuscleStatuses: ImmutableList<MuscleLoadEnum>,
    selectMuscleGroup: (id: String) -> Unit,
    selectMuscle: (id: String) -> Unit
) {

    val visiblePackAction = remember(item.muscles.map { it.load }) {
        item.muscles
            .map { it.load }.any { includedMuscleStatuses.contains(it) }
    }

    PaddingS()

    Column(
        modifier = Modifier.fillMaxWidth().padding(Design.dp.paddingM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextH4(
                modifier = Modifier.weight(1f),
                provideText = { item.name },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            PaddingS()

            if (visiblePackAction) {
                ButtonTextLink(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = if (item.isSelected) "CLEAR" else "ALL",
                    onClick = { selectMuscleGroup.invoke(item.id) },
                    color = if (item.isSelected) Design.colors.label else Design.colors.green
                )
            }
        }

        PaddingM()

        Box(modifier = Modifier.fillMaxWidth()) {

            Image(
                modifier = Modifier
                    .height(Design.dp.componentXXL)
                    .aspectRatio(1f)
                    .align(Alignment.CenterEnd),
                imageVector = item.bodyImageVector,
                contentDescription = null
            )

            Column(verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {

                item.muscles.forEach { muscle ->
                    MuscleChip(
                        muscle = muscle,
                        selectMuscle = selectMuscle
                    )
                }
            }
        }
    }
}

@Composable
private fun MuscleChip(
    muscle: Muscle,
    selectMuscle: (id: String) -> Unit
) {

    val contentColor = remember(muscle.load) {
        if (muscle.status == IncludedStatusEnum.EXCLUDED) {
            Design.palette.white10
        } else {
            when (muscle.load) {
                MuscleLoadEnum.HIGH -> Design.palette.content
                MuscleLoadEnum.MEDIUM -> Design.palette.content
                MuscleLoadEnum.LOW -> Design.palette.label
                null -> Design.palette.white10
            }
        }
    }

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.green.copy(alpha = 0.1f),
        borderColor = Design.colors.green,
        contentColor = Design.colors.content,
        enabled = muscle.status != IncludedStatusEnum.EXCLUDED
    )

    val unselectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.palette.white10,
        contentColor = contentColor,
        enabled = muscle.status != IncludedStatusEnum.EXCLUDED
    )

    val icon = remember(muscle.load) {
        if (muscle.status == IncludedStatusEnum.EXCLUDED) {
            null
        } else {
            when (muscle.load) {
                MuscleLoadEnum.HIGH -> Icons.highBattery
                MuscleLoadEnum.MEDIUM -> Icons.mediumBattery
                MuscleLoadEnum.LOW -> Icons.lowBattery
                null -> null
            }
        }
    }

    Chip(
        chipState = if (muscle.isSelected) selectedChipState else unselectedChipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        iconStart = icon,
        text = muscle.name
    )
}