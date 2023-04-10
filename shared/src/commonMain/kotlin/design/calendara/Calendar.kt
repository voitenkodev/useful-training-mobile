package design.calendara

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import design.Design
import utils.DateTimeKtx.firstDayOfMonth
import utils.DateTimeKtx.getDaysInMonth
import kotlin.math.ceil
import kotlin.math.roundToInt

/*
* P.S. Use Real values (Month: 1 - 12), (Days 1 - 28/31)
* */

@Composable
internal fun Calendar(
    month: Int,
    year: Int,
    listOfDays: List<Int>,
    headerColor: Color,
    labelsColor: Color,
    daysColor: Color,
    selectedColor: Color,
    dayClick: (Int) -> Unit
) {

    // OTHER
    val textMeasurer = rememberTextMeasurer()
    val labelStyle = Design.typography.Body2.copy(color = labelsColor, fontWeight = FontWeight.Bold)
    val dayStyle = Design.typography.Body.copy(color = daysColor)
    val radius = 10.dp
    val backgroundMain = Color.Transparent
    val weekDayLabelHeight = 24.dp

    // CALENDAR UTILS
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val daysInMonth = getDaysInMonth(month, year)
    val firstDayOfMonth = firstDayOfMonth(month, year)
    val padding = Design.dp.padding

    val dayRects = ArrayList<Pair<Int, Rect>>()

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(month, listOfDays) {
                detectTapGestures(
                    onTap = { tapOffset ->
                        var index = 0
                        for (rect in dayRects) {
                            if (rect.second.contains(tapOffset)) {
                                dayClick.invoke(rect.first)
                                break
                            }
                            index++
                        }
                    }
                )
            }
    ) {

        val labelsHeight = ceil((padding + weekDayLabelHeight).toPx())
        val dayWidth = (size.width - padding.toPx() - padding.toPx()) / 7f

        // MAIN background
        drawRoundRect(
            color = backgroundMain,
            size = Size(width = size.width, height = size.height),
            cornerRadius = CornerRadius(x = radius.toPx(), y = radius.toPx())
        )

        // HEADER background
        val path = Path().apply {
            addRoundRect(
                RoundRect(
                    rect = Rect(
                        offset = Offset.Zero,
                        size = Size(size.width, labelsHeight)
                    ),
                    topLeft = CornerRadius(radius.toPx(), radius.toPx()),
                    topRight = CornerRadius(radius.toPx(), radius.toPx()),
                )
            )
        }
        drawPath(path, color = headerColor)

        // Draw days of the week
        daysOfWeek.forEachIndexed { index, day ->
            val daysOfWeekTextLayoutResult: TextLayoutResult = textMeasurer.measure(text = AnnotatedString(day))

            drawText(
                textMeasurer = textMeasurer,
                text = day,
                style = labelStyle,
                topLeft = Offset(
                    x = dayWidth * index + padding.toPx() + ((dayWidth - daysOfWeekTextLayoutResult.size.width) / 2f),
                    y = padding.toPx()
                ),
                maxSize = IntSize(
                    width = ceil(this.size.width - padding.toPx()).roundToInt(),
                    height = ceil(weekDayLabelHeight.toPx()).roundToInt()
                )
            )
        }

        for (dayOfMonth in 1..daysInMonth) {
            val dayTextLayoutResult: TextLayoutResult = textMeasurer.measure(text = AnnotatedString(dayOfMonth.toString()))

            val column = (dayOfMonth - 1 + firstDayOfMonth.ordinal) % 7
            val row = (dayOfMonth - 1 + firstDayOfMonth.ordinal) / 7
            val countOfRows = ((daysInMonth - 1 + firstDayOfMonth.ordinal) / 7) + 1
            val dayHeight = (size.height - labelsHeight - padding.toPx()) / countOfRows
            val x = column * dayWidth + padding.toPx()
            val y = (row * dayHeight) + labelsHeight + (padding.toPx() / 2)

            val innerBackgroundPadding = 6

            // Rect for click
            dayRects.add(
                dayOfMonth to Rect(
                    offset = Offset(x = x + innerBackgroundPadding, y = y + innerBackgroundPadding),
                    size = Size(
                        width = dayWidth - innerBackgroundPadding - innerBackgroundPadding,
                        height = dayHeight - innerBackgroundPadding - innerBackgroundPadding
                    )
                )
            )

            listOfDays
                .count { it == dayOfMonth }
                .takeIf { it > 0 }
                ?.let {
                    drawRoundRect(
                        color = selectedColor,
                        topLeft = Offset(x = x + innerBackgroundPadding, y = y + innerBackgroundPadding),
                        size = Size(
                            width = dayWidth - innerBackgroundPadding - innerBackgroundPadding,
                            height = dayHeight - innerBackgroundPadding - innerBackgroundPadding
                        ),
                        cornerRadius = CornerRadius(x = radius.toPx(), y = radius.toPx())
                    )
                }

            drawText(
                textMeasurer = textMeasurer,
                text = dayOfMonth.toString(),
                style = dayStyle,
                topLeft = Offset(
                    x = x + ((dayWidth - dayTextLayoutResult.size.width) / 2f),
                    y = y + ((dayHeight - dayTextLayoutResult.size.height) / 2f),
                ),
                maxSize = IntSize(
                    width = ceil(this.size.width - padding.toPx()).roundToInt(),
                    height = ceil(dayHeight).roundToInt()
                )
            )
        }
    }
}
