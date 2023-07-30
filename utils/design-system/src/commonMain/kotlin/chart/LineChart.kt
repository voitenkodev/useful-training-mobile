package chart

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import utils.recomposeHighlighter

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    lines: () -> List<PointLine>,
) {

    val line by rememberUpdatedState(lines())

    if (line.isEmpty()) return

    Canvas(modifier = modifier.recomposeHighlighter()) {

        val innerLines = calculatePath(
            width = size.width,
            height = size.height,
            lines = line,
        )

        innerLines.forEach {

            // Line
            drawPath(
                path = it.path,
                color = it.lineColor,
                style = Stroke(
                    width = it.width.toPx(),
                    cap = StrokeCap.Round,
                    pathEffect = it.pathEffect
                ),
            )

            it.fillColor?.let { fillColor ->
                drawPath(
                    path = it.path.apply {
                        lineTo(size.width, size.height)
                        lineTo(0f, size.height)
                    },
                    brush = Brush.verticalGradient(
                        0.7f to fillColor,
                        1.0f to Color.Transparent
                    )
                )
            }

            it.point?.let { point ->
                it.offsets.forEach { offset ->
                    if (offset != Offset.Unspecified) drawCircle(
                        color = point.color,
                        radius = point.radius.toPx(),
                        center = offset
                    )
                }
            }
        }
    }
}