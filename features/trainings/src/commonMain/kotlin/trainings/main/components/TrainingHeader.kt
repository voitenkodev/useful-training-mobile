package trainings.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import basic.LineChart
import basic.LineChartDotsStyle
import basic.LineChartStyle
import components.cards.HorizontalValueCard
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.secondaryDefaultBackground
import recomposeHighlighter
import resources.Icons
import trainings.Training

@Composable
internal fun TrainingHeader(
    modifier: Modifier = Modifier,
    training: Training
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .recomposeHighlighter()
    ) {

        ChartBlock(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxHeight()
                .secondaryDefaultBackground(),
            title = "Volume",
            value = training.volume.kg(allowUnit = true),
            icon = Icons.weight,
            values = training.volumeExerciseList
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            HorizontalValueCard(
                title = "Duration",
                description = "${training.duration} min",
                startIcon = Icons.time to Color.Transparent
            )

            HorizontalValueCard(
                title = "Intensity",
                description = training.intensity,
                startIcon = Icons.weight to Color.Transparent
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

        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(
                    start = Design.dp.paddingM,
                    end = Design.dp.paddingM,
                    top = Design.dp.paddingM
                )
                .recomposeHighlighter(),
            values = values,
            chartStyle = LineChartStyle(
                lineColor = Design.colors.orange,
                dotsStyle = LineChartDotsStyle(
                    backgroundColor = Design.colors.content,
                    type = LineChartDotsStyle.DotsType.START_END,
                    width = 6.dp
                )
            )
        )

        HorizontalValueCard(
            title = title,
            description = value,
            startIcon = icon to Color.Transparent
        )
    }
}