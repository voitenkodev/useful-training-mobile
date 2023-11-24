package trainings.components

import Icons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import basic.BasicLineChart
import kotlinx.collections.immutable.ImmutableList
import molecule.IconSecondary
import molecule.TextBody3
import molecule.TextH4
import molecule.coloredDefaultBackgroundNoBorder
import molecule.secondaryDefaultBackground
import recomposeHighlighter
import trainings.state.Training

@Composable
internal fun TrainingHeader(
    modifier: Modifier = Modifier,
    training: Training
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        ChartBlock(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxHeight()
                .secondaryDefaultBackground(),
            title = "VOLUME",
            value = training.volume,
            icon = Icons.weight,
            values = training.volumeExerciseList
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            DefaultItem(
                modifier = Modifier
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingS),
                title = "Duration",
                subTitle = "${training.duration} min",
                icon = Icons.time
            )

            DefaultItem(
                modifier = Modifier
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingS),
                title = "Intensity",
                subTitle = training.intensity,
                icon = Icons.handWeight
            )
        }
    }
}

@Composable
private fun DefaultItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    icon: ImageVector
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconSecondary(
            modifier = Modifier
                .size(Design.dp.componentS)
                .coloredDefaultBackgroundNoBorder(Design.colors.orange)
                .padding(Design.dp.paddingS),
            color = Design.colors.content,
            imageVector = icon
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH4(
                provideText = { title }
            )

            TextBody3(
                provideText = { subTitle },
                color = Design.colors.caption
            )
        }
    }
}

@Composable
private fun ChartBlock(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: ImageVector,
    values: ImmutableList<Float>,
) {
    Column(modifier = modifier.recomposeHighlighter()) {

        BasicLineChart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = Design.dp.paddingM, end = Design.dp.paddingM, top = Design.dp.paddingM)
                .recomposeHighlighter(),
            values = values,
            color = Design.colors.orange,
            bottomSpacing = 20f,
            circleColor = Design.colors.content
        )

        DefaultItem(
            modifier = Modifier
                .padding(Design.dp.paddingS),
            title = title,
            subTitle = value,
            icon = icon
        )
    }
}