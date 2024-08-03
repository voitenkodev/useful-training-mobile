package exerciseexamplebuilder.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import exerciseexamplebuilder.main.models.Muscle
import exerciseexamplebuilder.main.models.MuscleGroup
import exerciseexamplebuilder.main.models.StatusEnum
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextH4
import percents
import resources.Icons

@Composable
internal fun MuscleGroup(
    item: MuscleGroup,
    selectMuscle: (id: String) -> Unit
) {

    PaddingS()

    Column(
        modifier = Modifier.width(340.dp).padding(Design.dp.paddingM),
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
                    .height(Design.dp.componentXL)
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

    val contentColor = remember(muscle.status) {
        when (muscle.status) {
            StatusEnum.UNSELECTED -> Design.palette.caption
            StatusEnum.SELECTED -> Design.palette.content
        }
    }

    val chipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = if (muscle.status == StatusEnum.SELECTED) muscle.color else Design.palette.white10,
        contentColor = contentColor
    )

    val iconStart = remember(muscle.status) {
        when (muscle.status) {
            StatusEnum.UNSELECTED -> Icons.redCircle
            StatusEnum.SELECTED -> Icons.checkOn
        }
    }

    Chip(
        chipState = chipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        text = "${muscle.percentage.percents()} ${muscle.name}",
        iconStart = iconStart
    )
}