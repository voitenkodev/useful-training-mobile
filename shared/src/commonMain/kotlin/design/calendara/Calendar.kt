package design.calendara

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import design.Design
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.minus
import kotlinx.datetime.plus

@Composable
fun Calendar(
    modifier: Modifier,
    month: Int,
    year: Int
) {

    // OTHER
    val textMeasurer = rememberTextMeasurer()
    val titleStyle = Design.typography.H2.copy(color = Design.colors.content)
    val labelStyle = Design.typography.Body2.copy(color = Design.colors.content)
    val dayStyle = Design.typography.Body.copy(color = Design.colors.content)
    val labelHeight = 30.dp

    // CALENDAR UTILS
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val daysInMonth = getDaysInMonth(month, year)
    val firstDayOfMonth = firstDayOfMonth(month, year)
    val lastDayOfMonth = lastDayOfMonth(month, year)
    val monthTitle = monthTitle(month)

    Canvas(modifier = modifier) {
        val dayWidth = size.width / 7f
        val dayHeight = size.height / 7f

        // Draw month title
        drawText(
            textMeasurer = textMeasurer,
            text = monthTitle,
            style = titleStyle,
        )

        // Draw days of the week
        daysOfWeek.forEachIndexed { index, day ->
            drawText(
                textMeasurer = textMeasurer,
                text = day,
                style = labelStyle,
                topLeft = Offset(x = dayWidth * index, y = labelHeight.toPx())
            )
        }

        val topPadding = (labelHeight + labelHeight).toPx()

        for (dayOfMonth in 1..daysInMonth) {
            val column = (dayOfMonth - 1 + firstDayOfMonth.ordinal) % 7
            val row = (dayOfMonth - 1 + firstDayOfMonth.ordinal) / 7
            val x = column * dayWidth
            val y = (row * dayHeight) + topPadding

            drawText(
                textMeasurer = textMeasurer,
                text = dayOfMonth.toString(),
                style = dayStyle,
                topLeft = Offset(x = x, y = y)
            )
        }
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