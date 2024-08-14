package heightpicker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import kotlin.math.abs
import kotlin.math.roundToInt

public const val DEFAULT_INITIAL_HEIGHT: Int = 165

@Composable
public fun HeightPicker(
    modifier: Modifier = Modifier,
    pickerStyle: HeightPickerStyle,
    minimal: Int = 110,
    maximum: Int = 250,
    initial: Int,
    stringProvider: (Int) -> String = { it.toString() },
    onValueChange: (Int) -> Unit
) {
    val style = Design.typography
        .H4
        .copy(color = Design.colors.content)
    val textMeasurer = rememberTextMeasurer()
    val internalInitial = remember { initial }
    var targetDistant by remember { mutableStateOf(0f) }
    var startDragPoint by remember { mutableStateOf(0f) }
    var oldDragPoint by remember { mutableStateOf(0f) }
    var selectedValue by remember { mutableStateOf(initial) }

    Canvas(
        modifier = modifier
            .height(76.dp)
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { startDragPoint = it.x },
                    onDragEnd = { oldDragPoint = targetDistant }
                ) { change, _ ->
                    val newDistance = oldDragPoint + (change.position.x - startDragPoint)
                    targetDistant = newDistance.coerceIn(
                        minimumValue = ((internalInitial) * pickerStyle.spaceInterval - maximum * pickerStyle.spaceInterval).toFloat(),
                        maximumValue = ((internalInitial) * pickerStyle.spaceInterval - minimal * pickerStyle.spaceInterval).toFloat()
                    )
                }
            }
    ) {

        val topLinerY = 0.0f
        val middlePoint = Offset(x = this.size.width / 2f, y = this.size.height / 2f)
        val rangeStart = selectedValue - pickerStyle.visibilityRange
        val rangeEnd = selectedValue + pickerStyle.visibilityRange

        val rect = RoundRect(
            rect = Rect(
                offset = Offset(x = 0f, y = topLinerY),
                size = this.size
            ),
        )

        val path = Path().apply { addRoundRect(rect) }

        clipPath(path = path) {


            for (value in rangeStart..rangeEnd) {
                if (value in minimal..maximum) {
                    val positionLineScaleX =
                        middlePoint.x + (pickerStyle.spaceInterval * (value - internalInitial.toFloat()) + targetDistant)

                    val lineType = when {
                        value % 10 == 0 -> LineType.TenStep
                        value % 5 == 0 -> LineType.FiveStep
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
                        else -> pickerStyle.oneLineLength.toPx()
                    }

                    val centerY = pickerStyle.tenStepLineLength.toPx() / 2
                    val lineStartY = centerY - lineHeightSize / 2
                    val lineEndY = centerY + lineHeightSize / 2

                    drawLine(
                        start = Offset(positionLineScaleX, lineStartY),
                        end = Offset(positionLineScaleX, lineEndY),
                        brush = SolidColor(lineColor),
                        strokeWidth = pickerStyle.strokeWidth.toPx(),
                        cap = StrokeCap.Round
                    )

                    if (abs(middlePoint.x - positionLineScaleX.roundToInt()) < 5) {
                        selectedValue = value
                        onValueChange(selectedValue)
                    }

                    if (lineType == LineType.TenStep) {
                        val dimensions = textMeasurer.measure(
                            text = (stringProvider.invoke(abs(value))),
                            style = style,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Visible
                        )

                        drawText(
                            textLayoutResult = dimensions,
                            topLeft = Offset(
                                x = positionLineScaleX - (dimensions.size.width / 2),
                                y = lineEndY + 12.dp.toPx()
                            ),
                        )
                    }
                }
            }
        }

        // ******************** MARKER START ********************

//        val circleRadius = pickerStyle.markerHeight.toPx() / 2
//        val circleCenter = Offset(
//            x = center.x,
//            y = topLinerY - circleRadius
//        )
//
//        val circlePath = Path().apply {
//            addOval(
//                Rect(
//                    circleCenter.x - circleRadius,
//                    circleCenter.y - circleRadius,
//                    circleCenter.x + circleRadius,
//                    circleCenter.y + circleRadius
//                )
//            )
//        }
//
//        val lineStart = Offset(
//            x = center.x,
//            y = circleCenter.y + circleRadius + 5f
//        )
//        val lineEnd = Offset(
//            x = center.x,
//            y = lineStart.y + 56f
//        )
//
//        drawPath(
//            path = circlePath,
//            color = pickerStyle.indicatorColor
//        )
//
//        drawLine(
//            color = pickerStyle.indicatorColor,
//            start = lineStart,
//            end = lineEnd,
//            strokeWidth = pickerStyle.strokeWidth.toPx() * 2,
//            cap = StrokeCap.Round
//        )

        // ******************** MARKER END ********************
    }
}