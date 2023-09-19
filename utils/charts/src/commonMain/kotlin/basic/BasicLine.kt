package basic

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
            drawPath(
                path = drawElement.path,
                color = lineConfigs.color,
                style = Stroke(
                    width = lineConfigs.width.toPx(),
                    cap = StrokeCap.Round,
                ),
            )

            drawPath(
                path = drawElement.path.apply {
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                },
                brush = Brush.verticalGradient(
                    0.0f to lineConfigs.color.copy(alpha = 0.7f),
                    0.9f to lineConfigs.color.copy(alpha = 0.0f)
                )
            )
        }
    }
}
