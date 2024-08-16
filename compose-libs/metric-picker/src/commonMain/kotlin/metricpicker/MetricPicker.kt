package metricpicker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
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

public const val BASIC_INITIAL_HEIGHT: Int = 165
public const val BASIC_INITIAL_WEIGHT: Int = 650

@Composable
public fun MetricPicker(
    modifier: Modifier = Modifier,
    pickerStyle: MetricPickerStyle,
    minimal: Int = 110,
    maximum: Int = 250,
    initial: Int,
    stringProvider: (Int) -> String = { it.toString() },
    onValueChange: (Int) -> Unit
) {
    val style = Design.typography
        .H4
        .copy(
            color = Design.colors.content,
        )
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
            cornerRadius = CornerRadius(
                x = pickerStyle.radius.toPx(),
                y = pickerStyle.radius.toPx(),
            )
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
                    val lineStartY = 0f
                    val lineEndY = lineHeightSize

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
                                y = lineEndY + 8.dp.toPx()
                            ),
                        )
                    }
                }
            }

            drawLine(
                start = Offset(
                    middlePoint.x,
                    0f
                ),
                end = Offset(
                    middlePoint.x,
                    pickerStyle.tenStepLineLength.toPx()
                ),
                brush = SolidColor(pickerStyle.indicatorColor),
                strokeWidth = pickerStyle.indicatorWidth.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}