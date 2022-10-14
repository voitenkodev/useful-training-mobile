import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import kotlin.math.absoluteValue

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    lines: List<PointLine>
) {

    val motionEvent = remember { mutableStateOf(MotionEvent.Idle) }
    val currentPosition = remember { mutableStateOf(Offset.Unspecified) }

    val drawModifier = modifier.pointerMotionEvents(
        onDown = { pointerInputChange: PointerInputChange ->
            currentPosition.value = pointerInputChange.position
            motionEvent.value = MotionEvent.Down
            pointerInputChange.consume()
        },
        onMove = { pointerInputChange: PointerInputChange ->
            currentPosition.value = pointerInputChange.position
            motionEvent.value = MotionEvent.Move
            pointerInputChange.consume()
        },
        onUp = { pointerInputChange: PointerInputChange ->
            motionEvent.value = MotionEvent.Up
            pointerInputChange.consume()
        },
        delayAfterDownInMillis = 25L
    )


    if (lines.isEmpty()) return

    Canvas(modifier = drawModifier) {

        val innerLines = calculatePath(lines = lines)

        when (motionEvent.value) {
            MotionEvent.Down -> {
                innerLines.find {
                    currentPosition.value.x + 20f

                    val filtered = it.offsets.filter { ofs ->
                        (ofs.x - currentPosition.value.x).absoluteValue < 20 && (ofs.y - currentPosition.value.y).absoluteValue < 20
                    }
                    Logger.i { "filtered = ${filtered}" }
                    Logger.i { "currentPosition = ${currentPosition.value}" }

                    val index = it.offsets.indexOf(currentPosition.value)
                    index != -1
                }

            }

            else -> Unit
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

            it.offsets.forEach { offset ->
                if (offset != Offset.Unspecified) drawCircle(
                    color = Color.Red,
                    radius = 6.dp.toPx(),
                    center = offset
                )
            }
        }
    }
}