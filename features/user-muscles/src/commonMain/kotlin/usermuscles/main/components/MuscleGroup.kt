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
import molecule.TextLabel
import usermuscles.main.models.Muscle
import usermuscles.main.models.MuscleType
import usermuscles.main.models.StatusEnum

@Composable
internal fun MuscleGroup(
    item: MuscleType,
    selectMuscle: (id: String) -> Unit
) {

    val included = remember(item.muscles) {
        item.muscles.filter { it.status == StatusEnum.INCLUDED }
    }

    val excluded = remember(item.muscles) {
        item.muscles.filter { it.status == StatusEnum.EXCLUDED }
    }

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

                if (included.isNotEmpty()) {
                    included.forEach { muscle ->
                        MuscleChip(
                            muscle = muscle,
                            selectMuscle = selectMuscle
                        )
                    }
                }

                if (included.isNotEmpty() && excluded.isNotEmpty()) {
                    PaddingM()
                }

                if (excluded.isNotEmpty()) {
                    TextLabel(
                        provideText = { "Excluded" },
                        color = Design.colors.orange
                    )

                    excluded.forEach { muscle ->
                        MuscleChip(
                            muscle = muscle,
                            selectMuscle = selectMuscle
                        )
                    }
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
            StatusEnum.EXCLUDED -> Design.palette.caption
            StatusEnum.INCLUDED -> Design.palette.content
        }
    }

    val chipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.palette.white10,
        contentColor = contentColor
    )

    Chip(
        chipState = chipState,
        onClick = { selectMuscle.invoke(muscle.id) },
        text = muscle.name
    )
}