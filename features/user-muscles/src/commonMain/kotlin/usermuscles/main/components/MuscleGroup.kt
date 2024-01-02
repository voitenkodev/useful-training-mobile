package usermuscles.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextH4
import resources.Icons
import usermuscles.main.models.Muscle
import usermuscles.main.models.MuscleType
import usermuscles.main.models.StatusEnum


@Composable
internal fun MuscleGroup(
    item: MuscleType,
    selectMuscle: (id: String) -> Unit
) {

    PaddingS()

    Column(
        modifier = Modifier.fillMaxWidth().padding(Design.dp.paddingM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextH4(
            modifier = Modifier.fillMaxWidth(),
            provideText = { item.name },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

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

    val contentColor = remember(muscle.status) {
        when (muscle.status) {
            StatusEnum.High -> Design.palette.content
            StatusEnum.Medium -> Design.palette.content
            StatusEnum.Low -> Design.palette.caption
        }
    }

    val unselectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.palette.white10,
        contentColor = contentColor
    )

    val icon = remember(muscle.status) {
        when (muscle.status) {
            StatusEnum.High -> Icons.highBattery
            StatusEnum.Medium -> Icons.mediumBattery
            StatusEnum.Low -> Icons.lowBattery
        }
    }

    Chip(
        chipState = if (muscle.isSelected) selectedChipState else unselectedChipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        iconStart = icon,
        text = muscle.name
    )
}