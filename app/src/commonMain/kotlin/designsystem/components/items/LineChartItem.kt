package designsystem.components.items

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.atomic.DesignComponent
import designsystem.components.LineChart
import designsystem.controls.PointLine
import designsystem.controls.secondaryBackground

@Composable
fun LineChartItem(
    modifier: Modifier = Modifier,
    lines: List<PointLine>
) = LineChart(
    modifier = modifier
        .secondaryBackground()
        .padding(DesignComponent.size.space),
    lines = lines
)
