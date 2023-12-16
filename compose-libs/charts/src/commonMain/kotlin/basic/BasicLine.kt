package basic

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import atom.Design
import kg

@Composable
public fun BasicLineChart(
    modifier: Modifier = Modifier,
    values: List<Float>,
    color: Color,
    circleColor: Color,
    bottomSpacing: Float = 0f,
    allowPoints: Boolean = false,
    allowBackground: Boolean = true
) {

    if (values.isEmpty()) return

    val textMeasurer = rememberTextMeasurer()
    val style = Design.typography.Body3.copy(color = Design.colors.content)

    val innerTextPadding = 10

    Canvas(modifier = modifier) {

        val drawElement = generatePath(
            width = size.width,
            height = size.height,
            line = values,
            color = color,
            bottomSpacing = bottomSpacing,
            circleColor = circleColor
        )

        drawElement.lineConfigs?.let { lineConfigs ->

            // Line
            drawPath(
                path = drawElement.path,
                color = lineConfigs.color,
                style = Stroke(
                    width = lineConfigs.width.toPx(),
                    cap = StrokeCap.Round,
                ),
            )

            // Background
            if (allowBackground) drawPath(
                path = drawElement.path.apply { lineTo(size.width, size.height); lineTo(0f, size.height) },
                brush = Brush.verticalGradient(
                    0.0f to lineConfigs.color.copy(alpha = 0.6f),
                    0.9f to lineConfigs.color.copy(alpha = 0.0f)
                )
            )


            // First point
            drawElement.listOfPoints.firstOrNull()?.let points@{ point ->

                val text = drawElement.values.lastOrNull()?.toInt()?.kg() ?: return@points

                drawCircle(
                    color = point.color,
                    radius = lineConfigs.width.toPx(),
                    center = Offset(point.x, point.y)
                )
            }

            // Last point
            drawElement.listOfPoints.lastOrNull()?.let points@{ point ->

                val text = drawElement.values.lastOrNull()?.toInt()?.kg() ?: return@points

                val dimensions = textMeasurer.measure(text, style)

                drawRoundRect(
                    color = point.color,
                    topLeft = Offset(
                        point.x - (dimensions.size.width / 2) - innerTextPadding,
                        point.y - (dimensions.size.height / 2) - innerTextPadding
                    ),
                    size = Size(
                        point.x + (dimensions.size.width / 2) + innerTextPadding,
                        point.y + (dimensions.size.height / 2) + innerTextPadding
                    ),
                    cornerRadius = CornerRadius(x = 15f, y = 15f)
                )

                drawText(
                    textLayoutResult = dimensions,
                    topLeft = Offset(x = point.x - (dimensions.size.width / 2), y = point.y - (dimensions.size.height / 2)),
                )
            }

            // All points
            if (allowPoints) drawElement.listOfPoints.dropLast(1).drop(1).forEach { point ->
                drawCircle(
                    color = point.color,
                    radius = lineConfigs.width.toPx(),
                    center = Offset(point.x, point.y)
                )
            }
        }
    }
}
