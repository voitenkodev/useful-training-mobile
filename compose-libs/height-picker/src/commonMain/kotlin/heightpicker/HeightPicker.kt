package heightpicker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import kotlin.math.abs
import kotlin.math.roundToInt

@Composable
public fun HeightPicker(
    modifier: Modifier = Modifier,
    pickerStyle: HeightPickerStyle,
    minimal: Int = 110,
    maximum: Int = 250,
    initial: Int,
    onValueChange: (Int) -> Unit
) {
    val style = Design.typography.Body3.copy(color = Design.colors.content)
    val textMeasurer = rememberTextMeasurer()
    val internalInitial = remember { initial }
    var targetDistant by remember { mutableStateOf(0f) }
    var startDragPoint by remember { mutableStateOf(0f) }
    var oldDragPoint by remember { mutableStateOf(0f) }
    var selectedHeight by remember { mutableStateOf(initial) }

    Canvas(
        modifier = modifier.pointerInput(Unit) {
            detectDragGestures(
                onDragStart = {
                    startDragPoint = it.x
                },
                onDragEnd = {
                    oldDragPoint = targetDistant
                }
            ) { change, _ ->
                val newDistance = oldDragPoint + (change.position.x - startDragPoint)
                targetDistant = newDistance.coerceIn(
                    minimumValue = ((internalInitial) * pickerStyle.spaceInterval - maximum * pickerStyle.spaceInterval).toFloat(),
                    maximumValue = ((internalInitial) * pickerStyle.spaceInterval - minimal * pickerStyle.spaceInterval).toFloat()
                )
            }
        }
    ) {

        val topLinerY = this.size.height / 2f
        val middlePoint = Offset(x = this.size.width / 2f, y = this.size.height / 2f)
        val rangeStart = selectedHeight - pickerStyle.visibilityRange
        val rangeEnd = selectedHeight + pickerStyle.visibilityRange

        drawRect(
            topLeft = Offset(x = 0f, y = topLinerY),
            size = this.size,
            color = pickerStyle.backgroundColor
        )

        for (height in rangeStart..rangeEnd) {
            if (height in minimal..maximum) {
                val positionLineScaleX =
                    middlePoint.x + (pickerStyle.spaceInterval * (height - internalInitial.toFloat()) + targetDistant)

                val lineType = when {
                    height % 10 == 0 -> LineType.TenStep
                    height % 5 == 0 -> LineType.FiveStep
                    else -> LineType.Normal
                }

                val lineColor = when (lineType) {
                    LineType.TenStep -> pickerStyle.tenStepLineColor
                    LineType.FiveStep -> pickerStyle.fiveStepLineColor
                    else -> pickerStyle.normalLineColor
                }

                val lineHeightSize = when (lineType) {
                    LineType.TenStep -> pickerStyle.tenStepLineLength.toPx()
                    LineType.FiveStep -> pickerStyle.fiveStepLineLength.toPx()
                    else -> pickerStyle.normalLineLength.toPx()
                }

                drawLine(
                    start = Offset(positionLineScaleX, topLinerY),
                    end = Offset(positionLineScaleX, topLinerY + lineHeightSize * 2f),
                    brush = SolidColor(lineColor),
                    strokeWidth = pickerStyle.strokeWidth.toPx()
                )

                if (abs(middlePoint.x - positionLineScaleX.roundToInt()) < 5) {
                    selectedHeight = height
                    onValueChange(selectedHeight)
                }

                if (lineType == LineType.TenStep) {
                    val dimensions = textMeasurer.measure(
                        text = (abs(height)).toString(),
                        style = style,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Visible
                    )

                    drawText(
                        textLayoutResult = dimensions,
                        topLeft = Offset(x = positionLineScaleX - (dimensions.size.width / 2), y = topLinerY + (lineHeightSize * 2f + 10)),
                    )
                }
            }
        }

        val middleTop = Offset(
            x = center.x,
            y = topLinerY - 30
        )
        val bottomLeft = Offset(
            x = center.x - 12f,
            y = 0f
        )
        val bottomRight = Offset(
            x = center.x + 12f,
            y = 0f
        )
        val indicator = Path().apply {
            moveTo(middleTop.x, middleTop.y)

            cubicTo(
                middleTop.x - 6f, middleTop.y + 6f,
                bottomLeft.x - 6f, bottomLeft.y - 6f,
                bottomLeft.x, bottomLeft.y
            )

            lineTo(bottomRight.x, bottomRight.y)

            cubicTo(
                bottomRight.x + 6f, bottomRight.y - 6f,
                middleTop.x + 6f, middleTop.y + 6f,
                middleTop.x, middleTop.y
            )
            close()
        }
        drawPath(
            path = indicator,
            color = pickerStyle.indicatorColor
        )
    }
}