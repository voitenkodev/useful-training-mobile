import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerInputChange
import kotlin.math.absoluteValue

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    lines: List<PointLine>,
    onClick: (PointLine, Int) -> Unit
) {

    val motionEvent = remember { mutableStateOf(MotionEvent.Idle) }
    val currentPosition = remember { mutableStateOf(Offset.Unspecified) }

    val drawModifier = modifier.pointerMotionEvents(
        delayAfterDownInMillis = 25L,
        onUp = { pointerInputChange: PointerInputChange ->
            currentPosition.value = pointerInputChange.position
            motionEvent.value = MotionEvent.Up
            pointerInputChange.consume()
        }
    )

    if (lines.isEmpty()) return

    Canvas(modifier = drawModifier) {

        val innerLines = calculatePath(
            width = size.width,
            height = size.height,
            lines = lines
        )
        if (motionEvent.value == MotionEvent.Up) {
            innerLines.onEach {
                val index = it.offsets.filter { it != Offset.Unspecified }.indexOfFirst { ofs ->
                    (ofs.x - currentPosition.value.x).absoluteValue < 20 && (ofs.y - currentPosition.value.y).absoluteValue < 20
                }
                if (index != -1) {
                    onClick.invoke(it, index)
                }
            }
        }

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
                    color = fillColor
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