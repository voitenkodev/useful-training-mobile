package components.charts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import atom.Design
import components.chart.PointCircle
import components.chart.PointLine
import components.items.LineChartItem

@Composable
public fun IntensityChart(
    modifier: Modifier = Modifier,
    provideData: () -> List<Float>,
    compareData: (() -> List<Float>) = { emptyList() },
) {
    val color = Design.colors.primary

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
        modifier = modifier,
        lines = { lines }
    )
}