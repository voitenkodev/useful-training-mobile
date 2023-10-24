package trainings.components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import molecular.PaddingM
import molecular.PaddingS
import molecular.TextBody1
import molecular.TextH4
import molecular.secondarySmallBackground
import recomposeHighlighter
import trainings.state.Exercise

@Composable
internal fun Exercise(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: Exercise
) {

    Column(
        modifier = modifier
            .padding(horizontal = Design.dp.paddingM),
    ) {

        PaddingS()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextH4(
                modifier = Modifier,
                provideText = { "$number" },
                fontWeight = FontWeight.Bold
            )

            TextH4(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { exercise.name },
                fontWeight = FontWeight.Bold
            )
        }

        PaddingS()

        FlowRow(
            modifier = Modifier.recomposeHighlighter(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            exercise.iterations.forEach {
                TextBody1(
                    modifier = Modifier
                        .secondarySmallBackground()
                        .padding(
                            horizontal = Design.dp.paddingM,
                            vertical = Design.dp.paddingXS
                        ).recomposeHighlighter(),
                    provideText = { it.weightAndRepeat }
                )
            }
        }

        PaddingM()
    }
}
