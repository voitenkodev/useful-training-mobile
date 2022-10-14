package components.items

import DesignComponent
import PointLine
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import components.LineChartBox
import controls.secondaryBackground

@Composable
fun LineChartItem(
    modifier: Modifier = Modifier,
    lines: List<PointLine>
) = LineChartBox(
    modifier = modifier
        .secondaryBackground()
        .padding(DesignComponent.size.space),
    lines = lines
)
