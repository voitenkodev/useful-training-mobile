package trainingbuilder.training_builder.components

import androidx.compose.foundation.clickable
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
import atom.Design
import molecule.PaddingS
import molecule.TextBody2
import molecule.TextH4
import molecule.secondarySmallBackground
import trainingbuilder.training_builder.state.Exercise

@Composable
internal fun Exercise(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: Exercise,
    onClick: () -> Unit
) {

    Column(modifier = modifier.clickable(onClick = onClick)) {

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
                provideText = { exercise.name },
                fontWeight = FontWeight.Bold
            )
        }

        PaddingS()

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            exercise.iterations.forEach {
                TextBody2(
                    modifier = Modifier
                        .secondarySmallBackground()
                        .padding(
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
