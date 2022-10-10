package designsystem.controls

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PointLine(
    val label: String,
    val yValue: List<Float>,
    val lineColor: Color,
    val fillColor: Color? = null,
    val pointColor: Color? = null,
    val pathWidth: Dp = 2.dp,
    val pathEffect: PathEffect? = null
)

@Composable
fun LineChartCanvas(
    modifier: Modifier = Modifier,
    lines: List<PointLine>
) {

    if (lines.isEmpty()) return

    Canvas(modifier = modifier) {

        val maxY = lines.maxOfOrNull { it.yValue.max() } ?: 0.0f
        val minY = lines.minOfOrNull { it.yValue.min() } ?: 0.0f

        val spaceX = size.width / ((lines.maxOfOrNull { it.yValue.size } ?: 1) - 1)
        val spacyY = size.height / (maxY - minY)

        val normX = mutableListOf<Float>()
        val normY = mutableListOf<Float>()

        val paths = lines.map {

            it to Path().apply {

                for (i in it.yValue.indices) {
                    val currentX = i * spaceX
                    if (i == 0) {
                        moveTo(currentX, size.height - ((it.yValue[i] - minY) * spacyY))
                    } else {

                        val previousX = (i - 1) * spaceX
                        val conX1 = (previousX + currentX) / 2f
                        val conX2 = (previousX + currentX) / 2f
                        val conY1 = size.height - ((it.yValue[i - 1] - minY) * spacyY)
                        val conY2 = size.height - ((it.yValue[i] - minY) * spacyY)
                        val conY3 = size.height - ((it.yValue[i] - minY) * spacyY)

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
                    if (it.pointColor != null) {
                        normX.add(currentX)
                        normY.add(size.height - ((it.yValue[i] - minY) * spacyY))
                    }
                }
            }
        }

        paths.forEach {
            // Line
            drawPath(
                path = it.second,
                color = it.first.lineColor,
                style = Stroke(
                    width = it.first.pathWidth.toPx(),
                    cap = StrokeCap.Round,
                    pathEffect = it.first.pathEffect
                ),
            )

            // Filled background
            it.first.fillColor?.let { fillColor ->
                drawPath(
                    path = it.second.apply {
                        lineTo(size.width, size.height)
                        lineTo(0f, size.height)
                    },
                    color = fillColor
                )
            }

            it.first.pointColor?.let { pointColor ->
                (normX.indices).forEach {
                    drawCircle(
                        color = pointColor,
                        radius = 5.dp.toPx(),
                        center = Offset(normX[it], normY[it])
                    )
                }
            }
        }
    }
}