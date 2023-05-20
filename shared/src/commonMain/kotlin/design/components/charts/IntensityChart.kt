package design.components.charts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import design.Design
import design.chart.PointCircle
import design.chart.PointLine
import design.components.items.LineChartItem
import utils.recomposeHighlighter

@Composable
fun IntensityChart(
    modifier: Modifier = Modifier,
    provideData: () -> List<Float>,
    compareData: (() -> List<Float>) = { emptyList() },
) {
    val color = Design.colors.unique.color4

    val colorDataPoint = Design.colors.content
    val colorCompareDataPoint = Design.colors.caption

    val lines by remember(provideData(), compareData()) {
        mutableStateOf(buildList {
            add(
                PointLine(
                    yValue = provideData(),
                    lineColor = color,
                    fillColor = color.copy(alpha = 0.2f),
                    label = "Intensity",
                    point = PointCircle(color = colorDataPoint)
                )
            )
            if (compareData().isNotEmpty()) add(
                PointLine(
                    yValue = compareData(),
                    lineColor = colorCompareDataPoint,
                    fillColor = colorCompareDataPoint.copy(alpha = 0.2f),
                    label = "Compare",
                )
            )
        })
    }

    LineChartItem(
        modifier = modifier.recomposeHighlighter(),
        lines = { lines }
    )
}