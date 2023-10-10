package basic

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun BasicLineChart(
    modifier: Modifier = Modifier,
    values: List<Float>,
    color: Color,
    bottomSpacing: Float = 0f
) {

    if (values.isEmpty()) return

    Canvas(modifier = modifier) {

        val drawElement = generatePath(
            width = size.width,
            height = size.height,
            line = values,
            color = color,
            bottomSpacing = bottomSpacing
        )

        drawElement.lineConfigs?.let { lineConfigs ->

//            Line
            drawPath(
                path = drawElement.path,
                color = lineConfigs.color,
                style = Stroke(
                    width = lineConfigs.width.toPx(),
                    cap = StrokeCap.Round,
                ),
            )

            // Background
//            drawPath(
//                path = drawElement.path.apply {
//                    lineTo(size.width, size.height)
//                    lineTo(0f, size.height)
//                },
//                color = lineConfigs.color
//                brush = Brush.verticalGradient(
//                    0.0f to lineConfigs.color,//.copy(alpha = 0.7f),
//                    0.9f to lineConfigs.color// .copy(alpha = 0.0f)
//                )
//            )

            // First point
            drawElement.listOfPoints.firstOrNull()?.let { point ->
                drawCircle(
                    color = lineConfigs.color,
                    radius = lineConfigs.width.toPx(),
                    center = Offset(point.x, point.y)
                )
            }

            // Last point
            drawElement.listOfPoints.lastOrNull()?.let { point ->
                drawCircle(
                    color = lineConfigs.color,
                    radius = lineConfigs.width.toPx(),
                    center = Offset(point.x, point.y)
                )
            }

            // Points
//            val pointRadius = lineConfigs.width.toPx()
//            for (point in drawElement.listOfPoints) {
//                drawCircle(
//                    color = lineConfigs.color,
//                    radius = pointRadius,
//                    center = Offset(point.x, point.y)
//                )
//            }
        }
    }
}
