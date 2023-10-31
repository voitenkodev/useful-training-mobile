package molecular

import Design
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import isInteger
import kotlin.math.abs

public data class ThumbRangeStateState(
    val id: String?,
    val positionInRange: Int,
    val color: Color
)

private data class ThumbInternalState(
    val id: String?,
    val positionInLine: Int,
    val positionBetween: Int,
    val color: Color,
    val offsetX: Float,
    val isSelected: Boolean = false
)

@Composable
public fun RangeSlider(
    modifier: Modifier = Modifier,
    range: ClosedRange<Int>,
    thumbs: List<ThumbRangeStateState>,
    onValueChange: (List<ThumbRangeStateState>) -> Unit,
    minimalRange: Int,
    lineColor: Color,
    requiredFilledRange: Boolean = true
) {

    require((requiredFilledRange && thumbs.sumOf { it.positionInRange } != range.endInclusive).not()) {
        "Using 'requiredFilledRange = true', sum of items should be ${range.endInclusive}, but == ${thumbs.sumOf { it.positionInRange }}"
    }

    val canvasSize = remember {
        mutableStateOf(Size(0f, 0f))
    }

    val minimalRangeWidth = remember(minimalRange, canvasSize.value) {
        canvasSize.value.width / range.endInclusive * minimalRange
    }

    val internalThumbs = remember(canvasSize.value, thumbs) {
        val thumbInternalStates = thumbs.mapIndexed { index, item ->
            val linePosition = thumbs.take(index + 1).sumOf { it.positionInRange }
            ThumbInternalState(
                id = item.id,
                positionInLine = linePosition,
                positionBetween = item.positionInRange,
                offsetX = (canvasSize.value.width / range.endInclusive) * linePosition,
                color = item.color
            )
        }
        mutableStateOf(if (canvasSize.value.width == 0f) emptyList() else thumbInternalStates)
    }

    val style = Design.typography.Body2.copy(color = Design.colors.content)

    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier
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

                    if (dragAmount.x.isInteger().not()) return@detectDragGestures

                    change.consume()


                    val selectedThumb = internalThumbs.value.firstOrNull { it.isSelected } ?: return@detectDragGestures

                    val thumbsInOrder = internalThumbs.value.sortedBy { it.offsetX }

                    val newPositions = thumbsInOrder.mapIndexed { index, thumb ->

                        val prevPosition =
                            if (index > 0) thumbsInOrder[index - 1].offsetX
                            else 0f

                        val nextPosition =
                            if (index < thumbsInOrder.size - 1) thumbsInOrder[index + 1].offsetX
                            else canvasSize.value.width

                        val newPosition =
                            if (selectedThumb == thumb) thumb.offsetX + dragAmount.x
                            else thumb.offsetX

                        val coerceValue = takeIf { index == internalThumbs.value.lastIndex }
                            ?.let { nextPosition }
                            ?: let { nextPosition - minimalRangeWidth }

                        newPosition.coerceIn(
                            minimumValue = prevPosition + minimalRangeWidth,
                            maximumValue = coerceValue.coerceAtLeast(0f)
                        )
                    }

                    val updatedThumbs = internalThumbs.value.mapIndexed { index, thumb ->
                        val newPositionInLine = (range.endInclusive / (canvasSize.value.width / newPositions[index])).toInt()
                        val newPositionBetween = newPositionInLine.minus((internalThumbs.value.getOrNull(index - 1)?.positionInLine ?: 0))
                        thumb.copy(positionInLine = newPositionInLine, positionBetween = newPositionBetween, offsetX = newPositions[index])
                    }

                    internalThumbs.value = updatedThumbs
                }
            }
    ) {
        canvasSize.value = size
        val lineHeight = canvasSize.value.height / 8
        val circleRadius = lineHeight * 2
        val circlePositionY = canvasSize.value.height - circleRadius
        val linePositionY = canvasSize.value.height - circleRadius

        drawRoundRect(
            color = lineColor,
            size = size.copy(height = lineHeight),
            topLeft = Offset(x = 0f, y = linePositionY),
            cornerRadius = CornerRadius(lineHeight / 2, lineHeight / 2)
        )

        internalThumbs.value.asReversed().forEach { thumb ->

            val dimensions = textMeasurer.measure(thumb.positionBetween.toString(), style)

            drawText(
                textMeasurer = textMeasurer,
                text = thumb.positionBetween.toString(),
                style = style,
                topLeft = Offset(x = thumb.offsetX - dimensions.size.width / 2, y = 0f)
            )

            drawRoundRect(
                color = thumb.color,
                size = Size(height = lineHeight, width = thumb.offsetX),
                topLeft = Offset(x = 0f, y = linePositionY),
                cornerRadius = CornerRadius(lineHeight / 2, lineHeight / 2)
            )

            drawCircle(
                color = thumb.color,
                radius = circleRadius,
                center = Offset(thumb.offsetX, circlePositionY)
            )
        }
    }
}

private fun List<ThumbInternalState>.findNearTo(offsetX: Float): ThumbInternalState? {
    if (isEmpty()) {
        return null
    }

    var nearest = this[0]
    var minDifference = abs(this[0].offsetX.minus(offsetX))

    for (element in this) {
        val difference = abs(element.offsetX - offsetX)
        if (difference < minDifference) {
            nearest = element
            minDifference = difference
        }
    }

    return nearest
}