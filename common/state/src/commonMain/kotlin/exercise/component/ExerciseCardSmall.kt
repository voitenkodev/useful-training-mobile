package exercise.component

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import atom.Design
import conditional
import exercise.ExerciseExample
import molecule.ButtonText
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextBody4
import molecule.TextH5
import percents

@Immutable
private data class MuscleUi(
    val text: String,
    val color: Color
)

@Composable
public fun ExerciseCardSmall(
    modifier: Modifier = Modifier,
    exerciseExample: ExerciseExample,
    viewDetails: () -> Unit,
    onClick: (() -> Unit)? = null
) {

    val muscles = remember(exerciseExample.exerciseExampleBundles) {
        exerciseExample.exerciseExampleBundles
            .sortedByDescending { it.percentage }
            .take(2)
            .mapIndexed { index, item ->
                MuscleUi(
                    text = "${item.muscle.name}: ${item.percentage.percents()}",
                    color = when (index) {
                        0 -> Design.palette.content
                        1 -> Design.palette.content.copy(0.7f)
                        else -> Design.palette.content.copy(0.5f)
                    }
                )
            }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(Design.dp.componentL)
            .background(
                Design.colors.black10,
                shape = Design.shape.default
            ).border(
                width = 1.dp,
                color = Design.colors.tertiary,
                shape = Design.shape.default
            ).clip(shape = Design.shape.default)
            .conditional(
                condition = onClick != null,
                onYes = {
                    if (onClick != null) this.clickable(onClick = onClick)
                    else this
                }
            )
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = exerciseExample.imageUrl,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(
            modifier = Modifier.padding(Design.dp.paddingM).fillMaxSize()
        ) {
            TextH5(
                provideText = { exerciseExample.name },
                maxLines = 2
            )
            PaddingM()

            PaddingWeight()

            muscles.forEach { muscle ->
                TextBody4(
                    provideText = { muscle.text },
                    color = muscle.color,
                    maxLines = 4
                )
            }
        }

        ButtonText(
            modifier = Modifier.padding(Design.dp.paddingM).align(Alignment.BottomEnd),
            text = "View Details",
            onClick = viewDetails,
            color = Design.colors.content
        )
    }
}
