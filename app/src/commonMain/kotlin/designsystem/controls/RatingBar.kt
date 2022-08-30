package designsystem.controls

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import designsystem.common.darkGray
import designsystem.common.yellow

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float = 0.0f,
    maxRating: Int = 5,
    colorEnabled: Color = yellow,
    colorDisabled: Color = darkGray
) = Row(modifier = modifier.wrapContentSize()) {
    (1..maxRating).forEach { step ->
        val stepRating = when {
            rating > step -> 1f
            step.rem(rating) < 1 -> rating - (step - 1f)
            else -> 0f
        }
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(starShape)
        ) {
            Canvas(modifier = Modifier.size(maxHeight)) {
                drawRect(
                    brush = SolidColor(colorDisabled),
                    size = Size(
                        height = size.height * 1.4f,
                        width = size.width * 1.4f
                    ),
                    topLeft = Offset(
                        x = -(size.width * 0.1f),
                        y = -(size.height * 0.1f)
                    )
                )
                if (stepRating > 0) {
                    drawRect(
                        brush = SolidColor(colorEnabled),
                        size = Size(
                            height = size.height * 1.1f,
                            width = size.width * stepRating
                        )
                    )
                }
            }
        }
    }
}

private val starShape = GenericShape { size, _ -> addPath(starPath(size.height)) }

private val starPath = { size: Float ->
    Path().apply {
        val outerRadius: Float = size / 1.8f
        val innerRadius: Double = outerRadius / 2.5
        var rot: Double = kotlin.math.PI / 2 * 3
        val cx: Float = size / 2
        val cy: Float = size / 20 * 11
        var x: Float
        var y: Float
        val step = kotlin.math.PI / 5

        moveTo(cx, cy - outerRadius)
        repeat(5) {
            x = (cx + kotlin.math.cos(rot) * outerRadius).toFloat()
            y = (cy + kotlin.math.sin(rot) * outerRadius).toFloat()
            lineTo(x, y)
            rot += step

            x = (cx + kotlin.math.cos(rot) * innerRadius).toFloat()
            y = (cy + kotlin.math.sin(rot) * innerRadius).toFloat()
            lineTo(x, y)
            rot += step
        }
        close()
    }
}