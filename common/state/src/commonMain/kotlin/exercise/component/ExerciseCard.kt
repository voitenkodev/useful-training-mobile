package exercise.component

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import atom.Design
import exercise.ExerciseExample
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.ButtonText
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextBody4
import molecule.TextH5
import molecule.secondaryDefaultBackground
import percents

@Composable
public fun ExerciseCard(
    modifier: Modifier = Modifier,
    exerciseExample: ExerciseExample,
    btn: Pair<String, () -> Unit>?,
    viewDetails: () -> Unit,
) {

    val muscles = remember(exerciseExample.exerciseExampleBundles) {
        exerciseExample.exerciseExampleBundles
            .sortedByDescending { it.percentage }
            .take(3)
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
        modifier
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = exerciseExample.imageUrl,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Row(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(vertical = Design.dp.paddingM, horizontal = Design.dp.paddingM),
            ) {

                TextH5(
                    provideText = { exerciseExample.name },
                    maxLines = 3,
                    color = Design.colors.content
                )

                ButtonText(
                    text = "View details",
                    onClick = viewDetails,
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

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(IntrinsicSize.Min)
                    .background(Design.colors.black30)
                    .padding(vertical = Design.dp.paddingM, horizontal = Design.dp.paddingM),
                horizontalAlignment = Alignment.End
            ) {

                ButtonSecondary(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Hide",
                    onClick = {}
                )

                PaddingM()

                PaddingWeight()

                if (btn != null) {
                    ButtonPrimary(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = btn.first,
                        onClick = btn.second
                    )
                }
            }
        }
    }
}