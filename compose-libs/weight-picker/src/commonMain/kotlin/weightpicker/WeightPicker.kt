package weightpicker

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
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
public fun WeightPicker(
    modifier: Modifier = Modifier,
    pickerStyle: WeightPickerStyle,
    minWeightGram: Int = 300,
    maxWeightGram: Int = 3000,
    initialWeightGram: Int = 300,
    onWeightChange: (Int) -> Unit
) {

    val internalInitialWeight = remember { initialWeightGram }
    val radius = pickerStyle.radius
    val scaleWidth = pickerStyle.scaleWidth
    var center by remember { mutableStateOf(Offset.Zero) }
    var circleCenter by remember { mutableStateOf(Offset.Zero) }
    var angle by remember { mutableStateOf(0f) }
    var dragStartedAngle by remember { mutableStateOf(0f) }
    var oldAngle by remember { mutableStateOf(0f) }
    val textMeasurer = rememberTextMeasurer()
    val style = Design.typography.Body2.copy(color = Design.colors.content)
    val angleVisibilityRange = 30f

    Canvas(
        modifier = modifier
            .pointerInput(
                key1 = true,
                block = {
                    detectDragGestures(
                        onDragStart = { offset ->
                            dragStartedAngle = -atan2(
                                y = circleCenter.x - offset.x,
                                x = circleCenter.y - offset.y
                            ) * (180f / PI.toFloat())
                        },
                        onDragEnd = {
                            oldAngle = angle
                        }
                    ) { change, _ ->

                        val touchAngle = -atan2(
                            y = circleCenter.x - change.position.x,
                            x = circleCenter.y - change.position.y
                        ) * (180f / PI.toFloat())

                        val newAngle = oldAngle + (touchAngle - dragStartedAngle)

                        angle = newAngle.coerceIn(
                            minimumValue = internalInitialWeight - maxWeightGram.toFloat(),
                            maximumValue = internalInitialWeight - minWeightGram.toFloat()
                        )

                        onWeightChange((internalInitialWeight - angle).roundToInt())
                    }
                }),
        onDraw = {
            center = this.center

            circleCenter = Offset(center.x, scaleWidth.toPx() / 2f + radius.toPx())
            val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f
            val innerRadius = radius.toPx() - scaleWidth.toPx() / 2f

            drawCircle(
                color = pickerStyle.backgroundColor,
                radius = radius.toPx(),
                center = circleCenter
            )

            val localMinWeightGram = (internalInitialWeight - angle - angleVisibilityRange).toInt()
            val localMaxWeightGram = (internalInitialWeight - angle + angleVisibilityRange).toInt()

            for (i in localMinWeightGram..localMaxWeightGram) {
                val angleInRad = (i - internalInitialWeight + angle - 90) * (PI / 180f).toFloat()

                val lineType = when {
                    i % 10 == 0 -> LineType.TenStep
                    i % 5 == 0 -> LineType.FiveStep
                    else -> LineType.Normal
                }
                val lineLength = when (lineType) {
                    LineType.FiveStep -> pickerStyle.fiveStepLineLength.toPx()
                    LineType.Normal -> pickerStyle.normalLineLength.toPx()
                    LineType.TenStep -> pickerStyle.tenStepLineLength.toPx()
                }
                val lineColor = when (lineType) {
                    LineType.FiveStep -> pickerStyle.fiveStepLineColor
                    LineType.Normal -> pickerStyle.normalLineColor
                    LineType.TenStep -> pickerStyle.tenStepLineColor
                }
                val lineStart = Offset(
                    x = (outerRadius - lineLength) * cos(angleInRad) + circleCenter.x,
                    y = (outerRadius - lineLength) * sin(angleInRad) + circleCenter.y
                )
                val lineEnd = Offset(
                    x = outerRadius * cos(angleInRad) + circleCenter.x,
                    y = outerRadius * sin(angleInRad) + circleCenter.y
                )
                val designLineStart = Offset(
                    x = (innerRadius - outerRadius) * cos(angleInRad) + circleCenter.x,
                    y = (innerRadius - outerRadius) * sin(angleInRad) + circleCenter.y
                )
                val designLineEnd = Offset(
                    x = (innerRadius + 175) * cos(angleInRad) + circleCenter.x,
                    y = (innerRadius + 175) * sin(angleInRad) + circleCenter.y
                )
                if (lineType is LineType.TenStep) {
                    val textRadius = outerRadius - lineLength - style.fontSize.toPx()
                    val x = textRadius * cos(angleInRad) + circleCenter.x
                    val y = textRadius * sin(angleInRad) + circleCenter.y

                    rotate(degrees = angleInRad * (180f / PI.toFloat()) + 90f, pivot = Offset(x, y)) {

                        val dimensions = textMeasurer.measure(
                            text = (i / 10).toString(),
                            style = style,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Visible
                        )

                        drawText(
                            textLayoutResult = dimensions,
                            topLeft = Offset(x = x - (dimensions.size.width / 2), y = y),
                        )
                    }

                    drawLine(
                        color = pickerStyle.designLinesColor,
                        start = designLineStart,
                        end = designLineEnd,
                        strokeWidth = 1.dp.toPx()
                    )
                }

                drawLine(
                    color = lineColor,
                    start = lineStart,
                    end = lineEnd,
                    strokeWidth = 1.dp.toPx()
                )
            }

            val middleTop = Offset(
                x = circleCenter.x,
                y = circleCenter.y - innerRadius - pickerStyle.scaleIndicatorLength.toPx()
            )
            val bottomLeft = Offset(
                x = circleCenter.x - 12f,
                y = circleCenter.y - innerRadius + 20
            )
            val bottomRight = Offset(
                x = circleCenter.x + 12f,
                y = circleCenter.y - innerRadius + 20
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
                color = pickerStyle.scaleIndicatorColor
            )
        }
    )
}