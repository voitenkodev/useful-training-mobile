package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.atomic.DesignComponent
import designsystem.controls.LineChart
import designsystem.controls.TextFieldBody2
import designsystem.controls.secondaryBackground

@Composable
fun LineChartItem(
    modifier: Modifier = Modifier,
    label: String,
    yPoints: List<Float>,
    lineColor: Color,
    fillColor: Color? = null,
    pointColor: Color? = null,
) {
    val minY = yPoints.min().toInt()
    val maxY = yPoints.max().toInt()
    val middleY = ((minY + maxY) / 2)
    val threeQuartersY = ((maxY + middleY) / 2)
    val quarterY = ((minY + middleY) / 2)

    Column(
        modifier = modifier
            .secondaryBackground()
            .padding(DesignComponent.size.space),
        verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
    ) {

        Label(
            modifier = Modifier.align(Alignment.End),
            label = label,
            color = lineColor
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                TextFieldBody2(
                    text = maxY.toString(),
                    textAlign = TextAlign.End

                )

                TextFieldBody2(
                    text = threeQuartersY.toString(),
                    textAlign = TextAlign.End

                )

                TextFieldBody2(
                    text = middleY.toString(),
                    textAlign = TextAlign.End

                )

                TextFieldBody2(
                    text = quarterY.toString(),
                    textAlign = TextAlign.End

                )

                TextFieldBody2(
                    text = minY.toString(),
                    textAlign = TextAlign.End
                )

                Spacer(modifier = Modifier.size(20.dp))
            }

            Column {
                LineChart(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    yPoints = yPoints,
                    lineColor = lineColor,
                    fillColor = fillColor,
                    pointColor = pointColor
                )

                Row(
                    modifier = Modifier.fillMaxWidth().height(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    yPoints.forEachIndexed { index, _ ->
                        TextFieldBody2(text = (index + 1).toString())
                    }
                }
            }
        }
    }
}

@Composable
private fun Label(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.size(14.dp).background(color))
        TextFieldBody2(text = label, color = DesignComponent.colors.caption)
    }
}