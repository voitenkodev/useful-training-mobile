package trainings.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextBody2
import recomposeHighlighter
import trainings.Exercise

@Composable
public fun Exercise(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: Exercise
) {

    Column(modifier = modifier) {

        PaddingS()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextBody1(
                modifier = Modifier,
                provideText = { "$number." },
            )

            TextBody1(
                provideText = { exercise.name },
            )
        }

        PaddingM()

        FlowRow(
            modifier = Modifier.recomposeHighlighter(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            exercise.iterations.forEach {
                TextBody2(
                    modifier = Modifier
                        .background(
                            color = Design.colors.tertiary,
                            shape = Design.shape.small
                        ).padding(
                            horizontal = Design.dp.paddingM,
                            vertical = Design.dp.paddingXS
                        ),
                    provideText = { it.weightAndRepeat }
                )
            }
        }

        PaddingXS()
    }
}
