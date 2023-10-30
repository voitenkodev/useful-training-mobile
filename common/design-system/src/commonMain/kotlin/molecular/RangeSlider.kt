package molecular

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

public data class ThumbRangeStateState(
    val id: String?,
    val positionInRange: Int,
    val color: Color,
)

private data class ThumbInternalState(
    val id: String?,
    val positionInLine: Int = 5,
    val color: Color,
    val positionX: Float,
    val isSelected: Boolean = false,
)

@Composable
public fun RangeSlider(
    range: ClosedRange<Int>,
    thumbs: List<ThumbRangeStateState>,
    onValueChange: (List<ThumbRangeStateState>) -> Unit,
    minimalRange: Int,
    lineColor: Color,
    requiredFilledRange: Boolean = true,
) {
    require((requiredFilledRange && thumbs.sumOf { it.positionInRange } != range.endInclusive).not()) {
        "Using 'requiredFilledRange = true', sum of items should be ${range.endInclusive}, but == ${thumbs.sumOf { it.positionInRange }}"
    }

    val canvasSize = remember { mutableStateOf(Size(0f, 0f)) }
    val minimalRangeWidth = remember(minimalRange, canvasSize.value) {
        canvasSize.value.width / range.endInclusive * minimalRange
    }

    val internalThumbs = remember(canvasSize.value, thumbs) {
        val thumbInternalStates = thumbs.mapIndexed { index, item ->
            val linePosition = thumbs.take(index + 1).sumOf { it.positionInRange }
            ThumbInternalState(
                id = item.id,
                positionInLine = linePosition,
                positionX = (canvasSize.value.width / range.endInclusive) * linePosition,
                color = item.color
            )
        }
        mutableStateOf(thumbInternalStates)
    }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .pointerInput(canvasSize.value, thumbs) {
                detectTapGestures(
                    onPress = {
                        val availableInteractionList = if (requiredFilledRange) {
                            internalThumbs.value.dropLast(1)
                        } else internalThumbs.value

                        val nearThumb = availableInteractionList
                            .findNearTo(it.x)
                            ?: return@detectTapGestures

                        internalThumbs.value = internalThumbs.value.map { item ->
                            item.copy(isSelected = item.id == nearThumb.id)
                        }
                    }
                )
            }.pointerInput(canvasSize.value, thumbs) {
                detectDragGestures(
                    onDragEnd = {
                        val result = internalThumbs.value.mapIndexed { index, item ->
                            ThumbRangeStateState(
                                id = item.id,
                                positionInRange = item.positionInLine - (internalThumbs.value.getOrNull(index - 1)?.positionInLine ?: 0),
                                color = item.color
                            )
                        }
                        onValueChange.invoke(result)
                    }
                ) { change, dragAmount ->
                    change.consume()

                    val selectedThumb = internalThumbs.value.firstOrNull { it.isSelected } ?: return@detectDragGestures

                    val thumbsInOrder = internalThumbs.value.sortedBy { it.positionX }

                    val newPositions = thumbsInOrder.mapIndexed { index, thumb ->

                        val prevPosition =
                            if (index > 0) thumbsInOrder[index - 1].positionX
                            else 0f

                        val nextPosition =
                            if (index < thumbsInOrder.size - 1) thumbsInOrder[index + 1].positionX
                            else canvasSize.value.width

                        val newPosition =
                            if (selectedThumb == thumb) thumb.positionX + dragAmount.x
                            else thumb.positionX

                        val coerceValue = takeIf { index == internalThumbs.value.lastIndex }
                            ?.let { nextPosition }
                            ?: let { nextPosition - minimalRangeWidth }

                        val newPositionInRange = newPosition.coerceIn(
                            minimumValue = prevPosition + minimalRangeWidth,
                            maximumValue = coerceValue.coerceAtLeast(0f)
                        )

                        newPositionInRange
                    }

                    val updatedThumbs = internalThumbs.value.mapIndexed { index, thumb ->
                        thumb.copy(
                            positionInLine = (range.endInclusive / (canvasSize.value.width / newPositions[index])).toInt(),
                            positionX = newPositions[index]
                        )
                    }

                    internalThumbs.value = updatedThumbs
                }
            }
    ) {
        canvasSize.value = size

        drawTrack(
            size = size,
            trackColor = lineColor
        )

        internalThumbs.value.asReversed().forEach { thumb ->

            drawTrack(
                size = Size(height = size.height, width = thumb.positionX),
                trackColor = thumb.color
            )

            drawCircle(
                color = thumb.color,
                radius = canvasSize.value.height / 2,
                center = Offset(thumb.positionX, size.height / 2f)
            )
        }
    }
}

private fun DrawScope.drawTrack(size: Size, trackColor: Color) {
    val height = size.height / 4
    drawRect(
        color = trackColor,
        size = size.copy(height = height),
        topLeft = Offset(x = 0f, y = size.height / 2 - (height / 2))
    )
}

private fun List<ThumbInternalState>.findNearTo(offsetX: Float): ThumbInternalState? {
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
