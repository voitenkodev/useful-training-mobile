package components.items

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import DesignComponent
import components.LineChart
import controls.secondaryBackground
import models.PointLineComponent

@Composable
fun LineChartItem(
    modifier: Modifier = Modifier,
    lines: List<PointLineComponent>
) = LineChart(
    modifier = modifier
        .secondaryBackground()
        .padding(DesignComponent.size.space),
    lines = lines
)
