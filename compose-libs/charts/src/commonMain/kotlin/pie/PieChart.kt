package pie

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


// Resource: https://stackoverflow.com/questions/75932353/how-to-check-which-arc-or-pie-chart-segment-clicked-in-jetpack-compose

public data class PieChartData(
    val value: Float,
    val color: Color,
    val title: String
)

@Composable
public fun PieChart(
    modifier: Modifier,
    data: List<ChartData>,
    startAngle: Float = 0f,
    outerRingPercent: Int = 35,
    innerRingPercent: Int = 10,
    dividerStrokeWidth: Dp = 0.dp,
    drawText: Boolean = true,
    onClick: ((data: ChartData, index: Int) -> Unit)? = null
) {

    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        val density = LocalDensity.current

        val width = constraints.maxWidth.toFloat()

        // Outer radius of chart. This is edge of stroke width as
        val radius = (width / 2f) * .9f
        val outerStrokeWidthPx =
            (radius * outerRingPercent / 100f).coerceIn(0f, radius)

        // Inner radius of chart. Semi transparent inner ring
        val innerRadius = (radius - outerStrokeWidthPx).coerceIn(0f, radius)
        val innerStrokeWidthPx =
            (radius * innerRingPercent / 100f).coerceIn(0f, radius)

        val lineStrokeWidth = with(density) { dividerStrokeWidth.toPx() }

        // Start angle of chart. Top center is -90, right center 0,
        // bottom center 90, left center 180
        val chartStartAngle = startAngle
        val animatableInitialSweepAngle = remember {
            Animatable(chartStartAngle)
        }

        val chartEndAngle = 360f + chartStartAngle

        val sum = data.sumOf {
            it.data.toDouble()
        }.toFloat()

        val coEfficient = 360f / sum
        var currentAngle = 0f
        val currentSweepAngle = animatableInitialSweepAngle.value

        val chartDataList = remember(data) {
            data.map {

                val chartData = it.data
                val range = currentAngle..currentAngle + chartData * coEfficient
                currentAngle += chartData * coEfficient

                AnimatedChartData(
                    color = it.color,
                    data = it.data,
                    selected = false,
                    range = range
                )
            }
        }

        chartDataList.forEach {
            LaunchedEffect(key1 = it.isSelected) {
                // This is for scaling radius
                val targetValue = (if (it.isSelected) width / 2 else radius) / radius

                // This is for increasing outer ring
//                val targetValue = if (it.isSelected) outerStrokeWidthPx + width / 2 - radius
//                else outerStrokeWidthPx
                it.animatable.animateTo(targetValue, animationSpec = tween(500))
            }
        }

        LaunchedEffect(key1 = animatableInitialSweepAngle) {
            animatableInitialSweepAngle.animateTo(
                targetValue = chartEndAngle,
                animationSpec = tween(
                    delayMillis = 1000,
                    durationMillis = 1500
                )
            )
        }

        val textMeasurer = rememberTextMeasurer()
        val textMeasureResults: List<TextLayoutResult> = remember(chartDataList) {
            chartDataList.map {
                textMeasurer.measure(
                    text = "%${it.data.toInt()}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        val chartModifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { position: Offset ->
                        val xPos = size.center.x - position.x
                        val yPos = size.center.y - position.y
                        val length = sqrt(xPos * xPos + yPos * yPos)
                        val isTouched = length in innerRadius - innerStrokeWidthPx..radius

                        if (isTouched) {
                            var touchAngle =
                                (-chartStartAngle + 180f + atan2(
                                    yPos,
                                    xPos
                                ) * 180 / PI) % 360f

                            if (touchAngle < 0) {
                                touchAngle += 360f
                            }


                            chartDataList.forEachIndexed { index, chartData ->
                                val range = chartData.range

                                val isTouchInArcSegment = touchAngle in range
                                if (chartData.isSelected) {
                                    chartData.isSelected = false
                                } else {
                                    chartData.isSelected = isTouchInArcSegment
                                    if (isTouchInArcSegment) {
                                        onClick?.invoke(
                                            ChartData(
                                                color = chartData.color,
                                                data = chartData.data
                                            ), index
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }

        PieChartImpl(
            modifier = chartModifier,
            chartDataList = chartDataList,
            textMeasureResults = textMeasureResults,
            currentSweepAngle = currentSweepAngle,
            chartStartAngle = chartStartAngle,
            chartEndAngle = chartEndAngle,
            outerRadius = radius,
            outerStrokeWidth = outerStrokeWidthPx,
            innerRadius = innerRadius,
            innerStrokeWidth = innerStrokeWidthPx,
            lineStrokeWidth = lineStrokeWidth,
            drawText = drawText
        )

    }
}

@Composable
private fun PieChartImpl(
    modifier: Modifier = Modifier,
    chartDataList: List<AnimatedChartData>,
    textMeasureResults: List<TextLayoutResult>,
    currentSweepAngle: Float,
    chartStartAngle: Float,
    chartEndAngle: Float,
    outerRadius: Float,
    outerStrokeWidth: Float,
    innerRadius: Float,
    innerStrokeWidth: Float,
    lineStrokeWidth: Float,
    drawText: Boolean
) {
    Canvas(modifier = modifier) {

        val width = size.width
        var startAngle = chartStartAngle

        for (index in 0..chartDataList.lastIndex) {

            val chartData = chartDataList[index]
            val range = chartData.range
            val sweepAngle = range.endInclusive - range.start
            val angleInRadians = (startAngle + sweepAngle / 2).degreeToRadian()
            val textMeasureResult = textMeasureResults[index]
            val textSize = textMeasureResult.size

            val currentStrokeWidth = outerStrokeWidth
            // This is for increasing stroke width without scaling
//            val currentStrokeWidth = chartData.animatable.value

            withTransform(
                {
                    val scale = chartData.animatable.value
                    scale(
                        scaleX = scale,
                        scaleY = scale
                    )
                }
            ) {

                if (startAngle <= currentSweepAngle) {

                    val color = chartData.color
                    val diff = (width / 2 - outerRadius) / outerRadius
                    val fraction = (chartData.animatable.value - 1f) / diff

                    val animatedColor = androidx.compose.ui.graphics.lerp(
                        color,
                        color.copy(alpha = .8f),
                        fraction
                    )

                    val colorInner = Color.Black.copy(alpha = 0.1f)


                    // Outer Arc Segment
                    drawArc(
                        color = animatedColor,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle.coerceAtMost(
                            currentSweepAngle - startAngle
                        ),
                        useCenter = false,
                        topLeft = Offset(
                            (width - 2 * innerRadius - currentStrokeWidth) / 2,
                            (width - 2 * innerRadius - currentStrokeWidth) / 2
                        ),
                        size = Size(
                            innerRadius * 2 + currentStrokeWidth,
                            innerRadius * 2 + currentStrokeWidth
                        ),
                        style = Stroke(currentStrokeWidth)
                    )


                    // Inner Arc Segment
                    drawArc(
                        color = colorInner,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle.coerceAtMost(
                            currentSweepAngle - startAngle
                        ),
                        useCenter = false,
                        topLeft = Offset(
                            (width - 2 * innerRadius) / 2 + innerStrokeWidth / 2,
                            (width - 2 * innerRadius) / 2 + innerStrokeWidth / 2
                        ),
                        size = Size(
                            2 * innerRadius - innerStrokeWidth,
                            2 * innerRadius - innerStrokeWidth
                        ),
                        style = Stroke(innerStrokeWidth)
                    )
                }

                val textCenter = textSize.center

                if (drawText && currentSweepAngle == chartEndAngle) {
                    drawText(
                        textLayoutResult = textMeasureResult,
                        color = Color.Black,
                        topLeft = Offset(
                            -textCenter.x + center.x
                                    + (innerRadius + currentStrokeWidth / 2) * cos(angleInRadians),
                            -textCenter.y + center.y
                                    + (innerRadius + currentStrokeWidth / 2) * sin(angleInRadians)
                        )
                    )
                }
            }

            startAngle += sweepAngle
        }

        for (index in 0..chartDataList.lastIndex) {

            val chartData = chartDataList[index]
            val range = chartData.range
            val sweepAngle = range.endInclusive - range.start

            // Divider
//            rotate(
//                90f + startAngle
//            ) {
//                drawLine(
//                    color = Color.White,
//                    start = Offset(
//                        center.x,
//                        (width / 2 - innerRadius + innerStrokeWidth)
//                            .coerceAtMost(width / 2)
//                    ),
//                    end = Offset(center.x, 0f),
//                    strokeWidth = lineStrokeWidth
//                )
//            }

            startAngle += sweepAngle
        }

    }
}

private fun Float.degreeToRadian(): Float {
    return (this * PI / 180.0).toFloat()
}

@Immutable
public data class ChartData(val color: Color, val data: Float)

@Immutable
internal class AnimatedChartData(
    val color: Color,
    val data: Float,
    selected: Boolean = false,
    val range: ClosedFloatingPointRange<Float>,
    val animatable: Animatable<Float, AnimationVector1D> = Animatable(1f)
) {
    var isSelected by mutableStateOf(selected)
}