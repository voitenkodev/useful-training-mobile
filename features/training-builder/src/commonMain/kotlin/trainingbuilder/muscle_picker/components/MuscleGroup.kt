package trainingbuilder.muscle_picker.components

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
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextH4
import resources.Icons
import trainingbuilder.muscle_picker.models.Muscle
import trainingbuilder.muscle_picker.models.MuscleType
import trainingbuilder.muscle_picker.models.PriorityEnum


@Composable
internal fun MuscleGroup(
    item: MuscleType,
    selectMuscleType: (id: String) -> Unit,
    selectMuscle: (id: String) -> Unit
) {

    val textColor = when (item.muscles.size) {
        item.muscles.count { c -> c.isSelected } -> Design.colors.caption
        else -> Design.colors.toxic
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

            ButtonTextLink(
                modifier = Modifier.padding(bottom = 4.dp),
                text = if (item.muscles.any { m -> m.isSelected.not() }) "ALL" else "CLEAR",
                onClick = { selectMuscleType.invoke(item.id) },
                color = textColor
            )
        }

        PaddingM()

        Box(modifier = Modifier.fillMaxWidth()) {

            Image(
                modifier = Modifier
                    .height(180.dp)
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

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.toxic.copy(alpha = 0.1f),
        borderColor = Design.colors.toxic,
        contentColor = Design.colors.content
    )

    val contentColor = remember(muscle.priority) {
        when (muscle.priority) {
            PriorityEnum.High -> Design.palette.content
            PriorityEnum.Medium -> Design.palette.content
            PriorityEnum.Low -> Design.palette.caption
        }
    }

    val unselectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.palette.white10,
        contentColor = contentColor
    )

    val icon = remember(muscle.priority) {
        when (muscle.priority) {
            PriorityEnum.High -> Icons.arrowUp to Design.palette.toxic
            PriorityEnum.Medium -> null
            PriorityEnum.Low -> Icons.arrowDown to Design.palette.orange
        }
    }

    Chip(
        chipState = if (muscle.isSelected) selectedChipState else unselectedChipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        iconStart = icon,
        text = muscle.name
    )
}