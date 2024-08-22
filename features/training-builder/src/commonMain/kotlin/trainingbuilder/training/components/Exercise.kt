package trainingbuilder.training.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingS
import molecule.TextBody1
import molecule.TextBody2
import trainingbuilder.training.models.BuildExercise

@Composable
internal fun Exercise(
    modifier: Modifier = Modifier,
    number: Int,
    buildExercise: BuildExercise,
    onClick: () -> Unit
) {

    Column(modifier = modifier.clickable(onClick = onClick)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            TextBody1(
                modifier = Modifier,
                provideText = { "$number" },
            )

            TextBody1(
                provideText = { buildExercise.name },
            )
        }

        PaddingS()

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            buildExercise.buildIterations.forEach {
                TextBody2(
                    modifier = Modifier
                        .background(
                            color = Design.colors.tertiary,
                            shape = Design.shape.small
                        ).padding(
                            horizontal = Design.dp.paddingM,
                            vertical = Design.dp.paddingXS
                        ),
                    provideText = { "${it.weight}x${it.repetitions}" }
                )
            }
        }

        PaddingS()
    }
}
