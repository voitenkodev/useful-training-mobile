package design.calendara

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import design.Design
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlin.math.ceil
import kotlin.math.roundToInt

@Composable
internal fun Calendar(
    modifier: Modifier,
    month: Int,
    year: Int,
) {

    // OTHER
    val textMeasurer = rememberTextMeasurer()
    val titleStyle = Design.typography.H2.copy(color = Design.colors.content)
    val labelStyle = Design.typography.Body2.copy(color = Design.colors.content)
    val dayStyle = Design.typography.Body.copy(color = Design.colors.content)
    val radius = 10.dp
    val backgroundMain = Design.colors.secondary
    val backgroundHeader = Design.colors.accent_primary
    val monthLabelHeight = 30.dp
    val weekDayLabelHeight = 22.dp

    // CALENDAR UTILS
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val daysInMonth = getDaysInMonth(month, year)
    val firstDayOfMonth = firstDayOfMonth(month, year)
    val lastDayOfMonth = lastDayOfMonth(month, year)
    val monthTitle = monthTitle(month)
    val padding = Design.dp.padding

    Canvas(modifier = modifier) {

        val labelsHeight = ceil((monthLabelHeight + padding + weekDayLabelHeight).toPx())
        val dayWidth = (size.width - padding.toPx() - padding.toPx()) / 7f
        val dayHeight = (size.height - labelsHeight - padding.toPx() - padding.toPx()) / 5f

        // Main background
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
                        size = Size(
                            size.width,
                            labelsHeight
                        )
                    ),
                    topLeft = CornerRadius(radius.toPx(), radius.toPx()),
                    topRight = CornerRadius(radius.toPx(), radius.toPx()),
                )
            )
        }
        drawPath(path, color = backgroundHeader)

        // Draw month title
        val textLayoutResult: TextLayoutResult = textMeasurer.measure(text = AnnotatedString(monthTitle))

        drawText(
            textMeasurer = textMeasurer,
            text = monthTitle,
            style = titleStyle,
            topLeft = Offset(
                x = (size.width - textLayoutResult.size.width) / 2,
                y = padding.toPx()
            ),
            maxSize = IntSize(
                width = ceil(this.size.width - padding.toPx()).roundToInt(),
                height = ceil(monthLabelHeight.toPx()).roundToInt()
            )
        )

        // Draw days of the week
        daysOfWeek.forEachIndexed { index, day ->
            val daysOfWeekTextLayoutResult: TextLayoutResult = textMeasurer.measure(text = AnnotatedString(day))

            drawText(
                textMeasurer = textMeasurer,
                text = day,
                style = labelStyle,
                topLeft = Offset(
                    x = dayWidth * index + padding.toPx() + ((dayWidth - daysOfWeekTextLayoutResult.size.width) / 2f),
                    y = monthLabelHeight.toPx() + padding.toPx()
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
            val x = column * dayWidth + padding.toPx()
            val y = (row * dayHeight) + labelsHeight + padding.toPx()

// background card
//            drawRoundRect(
//                color = Color.Cyan.copy(alpha = 0.2f),
//                topLeft = Offset(x = x, y = y),
//                size = Size(
//                    width = dayWidth,
//                    height = dayHeight
//                )
//            )

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
                    height = ceil(monthLabelHeight.toPx()).roundToInt()
                )
            )
        }
        // CENTER RED LINE
//        drawRect(
//            color = Color.Red,
//            topLeft = Offset(
//                x = (size.width - 4) / 2,
//                y= 0f
//            ),
//            size = Size(
//                width = 4f,
//                height = size.height
//            )
//        )
    }
}

fun firstDayOfMonth(month: Int, year: Int): DayOfWeek {
    return LocalDate(year, month, 1).dayOfWeek
}

fun lastDayOfMonth(month: Int, year: Int): Int {
    return LocalDate(year, month, 1)
        .plus(1, DateTimeUnit.MONTH)
        .minus(1, DateTimeUnit.DAY)
        .dayOfMonth
}

fun monthTitle(month: Int): String {
    return Month.values()[month - 1].name
}

fun getDaysInMonth(month: Int, year: Int): Int {
    val daysInMonth = when (month) {
        1 -> 31
        2 -> if (isLeapYear(year)) 29 else 28
        3 -> 31
        4 -> 30
        5 -> 31
        6 -> 30
        7 -> 31
        8 -> 31
        9 -> 30
        10 -> 31
        11 -> 30
        12 -> 31
        else -> throw IllegalArgumentException("Invalid month: $month")
    }
    return daysInMonth
}

fun isLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}