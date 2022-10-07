package designsystem.controls

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    yPoints: List<Float>,
    lineColor: Color,
    fillColor: Color? = null,
    pointColor: Color? = null,
) {

    Canvas(modifier = modifier) {

        val spaceX = size.width / (yPoints.size - 1)
        val maxY = yPoints.max()
        val spacyY = size.height / maxY
        val normX = mutableListOf<Float>()
        val normY = mutableListOf<Float>()

        val strokePath = Path().apply {

            for (i in yPoints.indices) {
                val currentX = i * spaceX

                if (i == 0) {

                    moveTo(currentX, size.height - (yPoints[i] * spacyY))

                } else {

                    val previousX = (i - 1) * spaceX

                    val conX1 = (previousX + currentX) / 2f
                    val conX2 = (previousX + currentX) / 2f

                    val conY1 = size.height - (yPoints[i - 1] * spacyY)
                    val conY2 = size.height - (yPoints[i] * spacyY)
                    val conY3 = size.height - (yPoints[i] * spacyY)

                    cubicTo(
                        x1 = conX1,
                        y1 = conY1,
                        x2 = conX2,
                        y2 = conY2,
                        x3 = currentX,
                        y3 = conY3
                    )
                }

                // Circle dot points
                normX.add(currentX)
                normY.add(size.height - (yPoints[i] * spacyY))

            }
        }

        // Line
        drawPath(
            path = strokePath,
            color = lineColor,
            style = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        )

        // Filled background
        if (fillColor != null) drawPath(
            path = strokePath.apply {
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
            },
            color = fillColor
        )

        // Dots
        if (pointColor != null) (normX.indices).forEach {
            drawCircle(
                color = pointColor,
                radius = 5.dp.toPx(),
                center = Offset(normX[it], normY[it])
            )
        }
    }
}