package trainings.components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1
import controls.TextFieldH4
import recomposeHighlighter
import trainings.state.Exercise

@Composable
internal fun Exercise(
    modifier: Modifier = Modifier,
    provideNumber: () -> Int,
    exercise: () -> Exercise
) {

    Row(
        modifier = modifier
            .padding(top = 8.dp, start = 4.dp, end = 4.dp)
            .height(IntrinsicSize.Min)
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextFieldH4(
                modifier = Modifier.padding(Design.dp.paddingS),
                provideText = { "${provideNumber()}" },
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .alpha(0.5f)
                    .background(Design.colors.caption),
            )
        }

        InternalExercise(
            modifier = Modifier.padding(
                vertical = Design.dp.paddingS,
                horizontal = Design.dp.paddingS
            ),
            exercise = exercise
        )
    }
}

@Composable
private fun InternalExercise(
    modifier: Modifier = Modifier,
    exercise: () -> Exercise
) {

    Column(
        modifier = modifier.recomposeHighlighter(),
    ) {

        TextFieldH4(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { exercise().name },
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingS)
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingS)
        )

        FlowRow(
            modifier = Modifier.recomposeHighlighter(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            exercise().iterations.forEach {
                TextFieldBody1(
                    modifier = Modifier
                        .background(
                            shape = Design.shape.small,
                            color = Design.colors.white5
                        ).padding(
                            horizontal = Design.dp.paddingM,
                            vertical = Design.dp.paddingXS
                        ).recomposeHighlighter(),
                    provideText = { it.weightAndRepeat }
                )
            }
        }
    }
}