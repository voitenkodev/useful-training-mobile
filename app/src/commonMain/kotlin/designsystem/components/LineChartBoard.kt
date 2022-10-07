package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import designsystem.atomic.DesignComponent
import designsystem.controls.LineChart
import designsystem.controls.TextFieldBody2

@Composable
fun LineChartBoard(
    modifier: Modifier = Modifier,
    label: String,
    yPoints: List<Float>,
    lineColor: Color,
    fillColor: Color? = null,
    pointColor: Color? = null,
) {
    val minY = yPoints.min()
    val maxY = yPoints.max()

    Column {
        Label(
            label = label,
            color = lineColor
        )

        Row(modifier) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextFieldBody2(text = maxY.toString())
                TextFieldBody2(text = minY.toString())
            }

            LineChart(
                modifier = Modifier.fillMaxSize(),
                yPoints = yPoints,
                lineColor = lineColor,
                fillColor = fillColor,
                pointColor = pointColor
            )
        }
    }
}

@Composable
private fun ColumnScope.Label(
    label: String,
    color: Color,
) {
    Row(
        modifier = Modifier.align(Alignment.End),
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.size(14.dp).background(color))
        TextFieldBody2(text = label, color = DesignComponent.colors.caption)
    }
}