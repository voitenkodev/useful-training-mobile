package components.charts

import Design
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import chart.PointCircle
import chart.PointLine
import components.items.LineChartItem
import recomposeHighlighter

@Composable
fun TonnageChart(
    modifier: Modifier = Modifier,
    provideData: () -> List<Float>,
    compareData: (() -> List<Float>) = { emptyList() },
) {
    val color = Design.colors.unique.color1

    val colorDataPoint = Design.colors.content
    val colorCompareDataPoint = Design.colors.caption

    val lines by remember(provideData(), compareData()) {
        mutableStateOf(buildList {
            add(
                PointLine(
                    yValue = provideData(),
                    lineColor = color,
                    fillColor = color.copy(alpha = 0.2f),
                    label = "Tonnage",
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