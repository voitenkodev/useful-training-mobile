package bar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlin.math.max

@Immutable
internal data class BarChartMax(
    val value: Float,
    val title: String,
)

@Immutable
internal data class BarChartFilled(
    val value: Float,
    val padding: Dp,
    val title: String,
    val textStyle: TextStyle,
)

@Immutable
internal data class BarChartColumn(
    val max: BarChartMax,
    val filled: BarChartFilled? = null,
    val xAxisLabel: String? = null,
    val isSelected: Boolean = false,
    val style: BarChartBarStyle
)

@Immutable
internal data class BarChartTextStyle(
    val textStyle: TextStyle,
    val padding: Dp,
)

@Immutable
internal data class BarChartBarStyle(
    val defaultColor: Color,
    val selectedColor: Color,
    val filledColor: Color
)

@Immutable
internal data class YAxis(
    val values: ImmutableList<String>,
    val textStyle: TextStyle,
    val endPadding: Dp,
    val startPadding: Dp,
    val barChartStartLine: BarChartLineStyle,
)

@Immutable
internal data class XAxis(
    val values: ImmutableList<String>,
    val textStyle: TextStyle,
    val padding: Dp,
    val barChartStartLine: BarChartLineStyle,
)

@Immutable
internal data class BarChartLineStyle(
    val color: Color,
    val width: Dp
)

@Composable
internal fun RoundedBarChart(
    modifier: Modifier = Modifier,
    data: List<BarChartColumn>,
    maxData: Float? = null,
    radius: Dp,
    spaceBetween: Dp,

    // Left labels
    yAxis: YAxis,

    // Bottom labels
    xAxis: XAxis,

    // Text under column
    topLabelStyleBarChart: BarChartTextStyle,

    onColumnClicked: (Int) -> Unit
) {

    val textMeasurer = rememberTextMeasurer()

    // Calculate maximum data value if not provided
    val maxValue = remember(maxData, data) {
        maxData ?: data.maxOfOrNull { it.max.value } ?: 0f
    }

    // Find the longest label in Y-axis values
    val longestYAxisValue = remember(yAxis.values) {
        yAxis.values.getLongestString() ?: ""
    }

    // Measure dimensions of the longest Y-axis value
    val yAxisMaxDimension = textMeasurer.measure(
        text = longestYAxisValue,
        style = yAxis.textStyle,
        maxLines = 1,
        softWrap = false,
        overflow = TextOverflow.Visible
    )

    // Collection to store rectangles for interaction
    val rects = remember(data) {
        mutableListOf<RoundRect>()
    }

    Canvas(modifier = modifier.pointerInput(Unit) {
        detectTapGestures { offset ->
            rects.forEachIndexed { index, rect ->
                if (offset.x >= rect.left && offset.x <= rect.right && offset.y >= rect.top && offset.y <= rect.bottom) {
                    onColumnClicked(index)
                    return@detectTapGestures
                }
            }
        }
    }) {
        rects.clear()

        // Convert dimension values to pixels
        val radiusFloat = radius.toPx()
        val spaceFloat = spaceBetween.toPx()

        // yAxis
        val yAxisLabelStartPaddingFloat = yAxis.startPadding.toPx()
        val yAxisLabelEndPaddingFloat = yAxis.endPadding.toPx()
        val yAxisLineWidthFloat = yAxis.barChartStartLine.width.toPx()
        val leftLabelSpace =
            yAxisMaxDimension.size.width + yAxisLabelStartPaddingFloat + yAxisLabelEndPaddingFloat + yAxisLineWidthFloat

        // Calculate width of each bar
        val barWidth = (size.width - (spaceFloat * (data.size - 1)) - leftLabelSpace) / data.size

        val topLabelPaddingFloat = xAxis.padding.toPx()
        val xAxisLabelPaddingFloat = xAxis.padding.toPx()
        val xAxisLineHeightFloat = xAxis.barChartStartLine.width.toPx()

        val xAxisPreferredLabelDimension = textMeasurer.measure(
            text = "temp",
            style = xAxis.textStyle,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Visible
        )

        val topPreferredDimension = textMeasurer.measure(
            text = "temp",
            style = topLabelStyleBarChart.textStyle,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Visible
        )

        val xAxisLabelSpace = xAxisPreferredLabelDimension.size.height + xAxisLabelPaddingFloat
        val topLabelSpace = topPreferredDimension.size.height + topLabelPaddingFloat
        val maxBarHeight = size.height - topLabelSpace

        // Iterate through data to draw bars
        data.forEachIndexed { index, value ->

            val customXAxisDimensions = textMeasurer.measure(
                text = value.xAxisLabel ?: "",
                style = xAxis.textStyle,
                maxLines = 1,
                softWrap = false, overflow
                = TextOverflow.Visible
            )

            val topDimensions = textMeasurer.measure(
                text = value.max.title,
                style = topLabelStyleBarChart.textStyle,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )

            val barHeight = (value.max.value / maxValue) * maxBarHeight
            val startX = index * barWidth + (spaceFloat * index) + leftLabelSpace
            val startY = size.height - barHeight
            val endX = startX + barWidth
            val endY = size.height

            val barColor = if (value.isSelected) {
                value.style.selectedColor
            } else {
                value.style.defaultColor
            }

            // Filled Values
            val filled = value.filled
            val filledHeight = if (filled == null) 0f else (filled.value / maxValue) * maxBarHeight
            val filledStartY = size.height - filledHeight
            val filledColor = value.style.filledColor

            clipPath(
                path = Path().apply {
                    val rect = RoundRect(
                        rect = Rect(startX, startY, endX, endY),
                        topLeft = CornerRadius(radiusFloat, radiusFloat),
                        topRight = CornerRadius(radiusFloat, radiusFloat)
                    )
                    // Add rect to interaction
                    rects.add(rect)
                    addRoundRect(rect)
                },
                block = {
                    // Draw Max column
                    drawRect(
                        color = barColor,
                        topLeft = Offset(startX, startY),
                        size = androidx.compose.ui.geometry.Size(
                            endX - startX,
                            max(barHeight - xAxisLabelSpace, 0f)
                        ),
                    )

                    // Draw Filled column
                    if (filled != null) {
                        drawRect(
                            color = filledColor,
                            topLeft = Offset(startX, filledStartY),
                            size = androidx.compose.ui.geometry.Size(
                                endX - startX,
                                max(filledHeight - xAxisLabelSpace, 0f)
                            ),
                        )
                    }
                }
            )

            // Draw filled label
            if (filled != null) {
                val filledLabelPaddingFloat = filled.padding.toPx()

                val filledDimensions = textMeasurer.measure(
                    text = filled.title,
                    style = filled.textStyle,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Visible
                )

                drawText(
                    textLayoutResult = filledDimensions,
                    topLeft = Offset(
                        x = startX + (barWidth / 2) - (filledDimensions.size.width / 2),
                        y = filledStartY - filledDimensions.size.height - filledLabelPaddingFloat
                    )
                )
            }

            // Draw top labels
            if (value.isSelected) {
                drawText(
                    textLayoutResult = topDimensions,
                    topLeft = Offset(
                        x = startX + (barWidth / 2) - (topDimensions.size.width / 2),
                        y = startY - topLabelSpace
                    )
                )
            }

            // Draw custom xAxis labels
            drawText(
                textLayoutResult = customXAxisDimensions,
                topLeft = Offset(
                    x = startX + (barWidth / 2) - (customXAxisDimensions.size.width / 2),
                    y = endY - customXAxisDimensions.size.height
                )
            )
        }

        // Draw xAxis basic labels

        // Calculate the total width of all labels
        val totalLabelsWidth = xAxis.values.sumOf { value ->
            val labelDimensions = textMeasurer.measure(
                text = value,
                style = xAxis.textStyle,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )
            labelDimensions.size.width
        }

        // Calculate the interval between each label
        val interval = (size.width - totalLabelsWidth - leftLabelSpace) / (xAxis.values.size - 1)

        // Draw X-axis values
        var currentX =
            yAxisMaxDimension.size.width + yAxisLabelStartPaddingFloat + yAxisLabelEndPaddingFloat + yAxisLineWidthFloat

        xAxis.values.forEach { value ->
            val labelDimensions = textMeasurer.measure(
                text = value,
                style = xAxis.textStyle,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )
            drawText(
                textLayoutResult = labelDimensions,
                topLeft = Offset(
                    x = currentX,
                    y = size.height - labelDimensions.size.height
                )
            )
            currentX += labelDimensions.size.width + interval
        }

        // Draw X-axis line
        drawLine(
            brush = SolidColor(value = xAxis.barChartStartLine.color),
            start = Offset(
                x = 0f + leftLabelSpace,
                y = size.height - xAxisLabelSpace - xAxisLineHeightFloat / 2
            ),
            end = Offset(
                x = size.width,
                y = size.height - xAxisLabelSpace - (xAxisLineHeightFloat / 2)
            ),
            strokeWidth = xAxisLineHeightFloat
        )

        // Draw Y-axis line
        drawLine(
            brush = SolidColor(value = yAxis.barChartStartLine.color),
            start = Offset(x = yAxisLineWidthFloat / 2, y = topLabelSpace),
            end = Offset(x = yAxisLineWidthFloat / 2, y = size.height - xAxisLabelSpace),
            strokeWidth = yAxisLineWidthFloat
        )

        // Draw Y-axis values
        val spaceBetweenYAxis =
            (size.height - xAxisLabelSpace - yAxisMaxDimension.size.height - topLabelSpace) / (yAxis.values.size - 1)
        val yAxisStartPaddingFloat = yAxis.startPadding.toPx() + yAxisLineWidthFloat

        yAxis.values.forEachIndexed { index, value ->
            val yAxisValueDimensions = textMeasurer.measure(
                text = value,
                style = yAxis.textStyle,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )

            val startY =
                size.height - xAxisLabelSpace - yAxisValueDimensions.size.height - spaceBetweenYAxis * index

            drawText(
                textLayoutResult = yAxisValueDimensions,
                topLeft = Offset(x = yAxisStartPaddingFloat, y = startY)
            )
        }
    }
}

@Composable
private fun BarChartPreview() {

    val topTextStyle = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 15.sp,
        color = Color(0xFF000000)
    )

    val bottomTextStyle = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 13.sp,
        color = Color(0xFFA7A7A7)
    )

    val leftTextStyle = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 13.sp,
        color = Color(0xFFA7A7A7)
    )
    val innerTextStyle = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 13.sp,
        color = Color(0xFF7D7D7D)
    )


    val data = listOf(
        BarChartColumn(
            max = BarChartMax(
                value = 85f,
                title = "84%",
            ),
            filled = BarChartFilled(
                value = 18f,
                title = "12%",
                textStyle = innerTextStyle,
                padding = 4.dp

            ),
            xAxisLabel = "4/01-4/07",
            isSelected = true,
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ), BarChartColumn(
            max = BarChartMax(
                value = 44f,
                title = "44%",
            ),
            filled = BarChartFilled(
                value = 44f,
                title = "12%",
                textStyle = innerTextStyle,
                padding = 4.dp
            ),
            xAxisLabel = "4/08-4/15",
            isSelected = false,
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(
                value = 22f,
                title = "22%",
            ),
            filled = BarChartFilled(
                value = 14f,
                title = "12%",
                textStyle = innerTextStyle,
                padding = 4.dp
            ),
            xAxisLabel = "4/16-4/23",
            isSelected = false,
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(
                value = 88f,
                title = "88%",
            ),
            xAxisLabel = "4/24-4/31",
            isSelected = false,
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        )
    )

    Column(
        modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        RoundedBarChart(
            data = data,
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color.White),
            radius = 12.dp,
            maxData = 100f,
            spaceBetween = 20.dp,
            xAxis = XAxis(
                barChartStartLine = BarChartLineStyle(
                    color = Color(0xFFD9D9D9),
                    width = 1.dp
                ),
                padding = 9.dp,
                textStyle = bottomTextStyle,
                values = persistentListOf()
            ),
            topLabelStyleBarChart = BarChartTextStyle(
                textStyle = topTextStyle, padding = 9.dp
            ),
            yAxis = YAxis(
                values = persistentListOf("0", "20%", "40%", "60%", "80%", "100%"),
                textStyle = leftTextStyle,
                endPadding = 21.dp,
                startPadding = 6.dp,
                barChartStartLine = BarChartLineStyle(
                    color = Color(0xFFD9D9D9), width = 1.dp
                )
            ),
            onColumnClicked = {

            }
        )
    }
}

@Composable
private fun BarChartPreview2() {

    val topTextStyle = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 15.sp,
        color = Color(0xFF000000)
    )

    val bottomTextStyle = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 13.sp,
        color = Color(0xFFA7A7A7)
    )

    val leftTextStyle = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 13.sp,
        color = Color(0xFFA7A7A7)
    )

    val data = listOf(
        BarChartColumn(
            max = BarChartMax(value = 85f, title = "84%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),
        BarChartColumn(
            max = BarChartMax(value = 44f, title = "44%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 22f, title = "22%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 22f, title = "22%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 22f, title = "22%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 88f, title = "88%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 88f, title = "88%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 88f, title = "88%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        ),

        BarChartColumn(
            max = BarChartMax(value = 88f, title = "88%"),
            style = BarChartBarStyle(
                defaultColor = Color(0xFFF7F7F7),
                filledColor = Color(0xFF797979),
                selectedColor = Color(0xFFD9D9D9)
            ),
        )
    )

    Column(
        modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        RoundedBarChart(
            data = data,
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color.White),
            radius = 12.dp,
            maxData = 100f,
            spaceBetween = 20.dp,
            xAxis = XAxis(
                barChartStartLine = BarChartLineStyle(
                    color = Color(0xFFD9D9D9),
                    width = 1.dp
                ),
                padding = 8.dp,
                textStyle = bottomTextStyle,
                values = persistentListOf("QWERTY1", "AS", "QWERTY 2")
            ),
            topLabelStyleBarChart = BarChartTextStyle(
                textStyle = topTextStyle, padding = 9.dp
            ),
            yAxis = YAxis(
                values = persistentListOf("0", "20%", "40%", "60%", "80%", "100%"),
                textStyle = leftTextStyle,
                endPadding = 21.dp,
                startPadding = 6.dp,
                barChartStartLine = BarChartLineStyle(
                    color = Color(0xFFD9D9D9),
                    width = 1.dp
                )
            ),
            onColumnClicked = {

            }
        )
    }
}