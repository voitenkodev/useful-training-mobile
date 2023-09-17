package chart.basic

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import basic.generatePath

@Composable
fun BasicLineChart(
    modifier: Modifier = Modifier,
    values: List<Float>,

    color: Color
) {

    if (values.isEmpty()) return

    Canvas(modifier = modifier) {

        val drawElement = generatePath(
            width = size.width,
            height = size.height,
            line = values,
            color = color
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
                    0.0f to lineConfigs.color.copy(alpha= 0.7f),
                    0.9f to lineConfigs.color.copy(alpha= 0.0f)
                )
            )
        }

//            it.fillColor?.let { fillColor ->
//                drawPath(
//                    path = it.path.apply {
//                        lineTo(size.width, size.height)
//                        lineTo(0f, size.height)
//                    },
//                    brush = Brush.verticalGradient(
//                        0.7f to fillColor,
//                        1.0f to Color.Transparent
//                    )
//                )
//            }
//
//            it.point?.let { point ->
//                it.offsets.forEach { offset ->
//                    if (offset != Offset.Unspecified) drawCircle(
//                        color = point.color,
//                        radius = point.radius.toPx(),
//                        center = offset
//                    )
//                }
//            }
    }
}
