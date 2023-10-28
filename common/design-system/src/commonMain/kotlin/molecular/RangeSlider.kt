@file:Suppress("NAME_SHADOWING")

package molecular

import Design
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.abs

private data class Thumb(
    val id: String,
    val positionInRange: Float = 0.5f,
    val color: Color,
    val positionX: Float,
    val isSelected: Boolean = false
)

private fun List<Thumb>.findNearTo(offsetX: Float): Thumb? {
    if (isEmpty()) {
        return null
    }
    var nearest = this[0]
    var minDifference = abs(this[0].positionX.minus(offsetX))

    for (element in this) {
        val difference = abs(element.positionX - offsetX)
        if (difference < minDifference) {
            nearest = element
            minDifference = difference
        }
    }

    return nearest
}

@Composable
public fun MultiThumbRangeSlider(
    range: ClosedFloatingPointRange<Float> = 0f..100f,
    thumbs: List<Pair<String, Float>>,
    lineColor: Color
) {
    val thumbColor = Design.colors.accentPrimary

    val canvasSize = remember { mutableStateOf(Size(0f, 0f)) }

    val thumbs = remember(canvasSize.value) {
        val thumbs = thumbs.map {
            Thumb(
                id = it.first,
                positionInRange = it.second,
                positionX = (canvasSize.value.width / range.endInclusive) * it.second,
                color = thumbColor
            )
        }
        mutableStateOf(thumbs)
    }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .pointerInput(canvasSize.value) {
                detectTapGestures(
                    onPress = {
                        val x = it.x

                        val nearThumb = thumbs.value
                            .findNearTo(x)
                            ?: return@detectTapGestures

                        thumbs.value = thumbs.value.map { item ->
                            item.copy(isSelected = item.id == nearThumb.id)
                        }
                    }
                )
            }.pointerInput(canvasSize.value) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    val selectedThumb = thumbs.value.firstOrNull { it.isSelected } ?: return@detectDragGestures

                    thumbs.value = thumbs.value.map {
                        if (it.id == selectedThumb.id) {
                            val newPosition = it.positionX + dragAmount.x
                            it.copy(
                                positionInRange = range.endInclusive / (canvasSize.value.width / newPosition),
                                positionX = newPosition
                            )
                        } else it
                    }
                }
            }
    ) {
        canvasSize.value = size

        drawTrack(size, lineColor)

        thumbs.value.forEach { thumb ->
            drawCircle(
                color = thumb.color,
                radius = 16f,
                center = Offset(thumb.positionX, size.height / 2f)
            )
        }
    }
}

public fun DrawScope.drawTrack(size: Size, trackColor: Color) {
    val height = size.height / 4
    drawRect(
        color = trackColor,
        size = size.copy(height = height),
        topLeft = Offset(x = 0f, y = size.height / 2 - (height / 2))
    )
}