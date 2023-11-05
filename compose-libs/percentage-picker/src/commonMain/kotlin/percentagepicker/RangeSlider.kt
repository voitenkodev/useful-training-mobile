package percentagepicker

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
import androidx.compose.ui.text.style.TextOverflow
import atom.Design

@Composable
public fun RangeSlider(
    modifier: Modifier = Modifier,
    range: ClosedRange<Int>,
    thumbs: List<ThumbRangeState>,
    onValueChange: (List<ThumbRangeState>) -> Unit,
    minimalRange: Int,
    lineColor: Color,
    requiredFilledRange: Boolean = true
) {
    require((requiredFilledRange && thumbs.sumOf { it.positionInRange } != range.endInclusive).not()) {
        "Using 'requiredFilledRange = true', sum of items should be ${range.endInclusive}, but == ${thumbs.sumOf { it.positionInRange }}"
    }

    val canvasSize = remember { mutableStateOf(Size(0f, 0f)) }

    val internalThumbs = remember(canvasSize.value, thumbs) {
        val thumbInternalStates = thumbs.toInternal(range = range, canvasSize = canvasSize.value)
        mutableStateOf(if (canvasSize.value.width == 0f) emptyList() else thumbInternalStates)
    }

    val style = Design.typography.Body2.copy(color = Design.colors.content)
    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier.pointerInput(canvasSize.value, thumbs) {
            detectTapGestures(
                onPress = {
                    val availableInteractionList =
                        if (requiredFilledRange) internalThumbs.value.dropLast(1)
                        else internalThumbs.value

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
                    onValueChange.invoke(internalThumbs.value.toExternal())
                }
            ) { change, _ ->

                change.consume()

                val selectedThumb = internalThumbs
                    .value
                    .firstOrNull { it.isSelected }
                    ?: return@detectDragGestures

                val recalculatedPositionInLine = proportionForPosition(
                    range = range,
                    canvasSize = canvasSize.value,
                    newOffsetX = change.position.x
                )

                if (selectedThumb.positionInLine == recalculatedPositionInLine) return@detectDragGestures

                val newThumbPositions = internalThumbs.value.mapIndexed { index, thumb ->

                    val undoPosition =
                        if (index > 0) internalThumbs.value[index - 1].positionInLine
                        else range.start

                    val afterPosition =
                        if (index < internalThumbs.value.size - 1) internalThumbs.value[index + 1].positionInLine
                        else range.endInclusive

                    val newPosition =
                        if (selectedThumb == thumb) proportionForPosition(
                            range = range,
                            canvasSize = canvasSize.value,
                            newOffsetX = change.position.x
                        ) else thumb.positionInLine

                    if (newPosition == thumb.positionInLine && selectedThumb == thumb) return@detectDragGestures

                    val coerceValue = takeIf { index == internalThumbs.value.lastIndex }
                        ?.let { afterPosition }
                        ?: let { afterPosition - minimalRange }

                    newPosition.coerceIn(
                        minimumValue = undoPosition + minimalRange,
                        maximumValue = coerceValue.coerceAtLeast(0)
                    )
                }

                val updatedThumbs = internalThumbs.value.mapIndexed { index, thumb ->
                    val newOffsetX = proportionForOffset(
                        range = range,
                        canvasSize = canvasSize.value,
                        newPosition = newThumbPositions[index]
                    )

                    thumb.copy(
                        positionInLine = newThumbPositions[index],
                        offsetX = newOffsetX
                    )
                }

                val updatedThumbPositionsBetween = updatedThumbs.mapIndexed { index, item ->
                    val newPositionBetween = item.positionInLine - (updatedThumbs.getOrNull(index - 1)?.positionInLine ?: 0)
                    item.copy(positionBetween = newPositionBetween)
                }

                internalThumbs.value = updatedThumbPositionsBetween
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

            val text = thumb.positionBetween.toString()
            val dimensions = textMeasurer.measure(text, style)

            drawText(
                textMeasurer = textMeasurer,
                text = text,
                style = style,
                topLeft = Offset(x = thumb.offsetX - (dimensions.size.width / 2), y = 0f),
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
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