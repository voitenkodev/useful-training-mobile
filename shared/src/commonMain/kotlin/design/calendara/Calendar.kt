package design.calendara

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldH2
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
    listOfValues: List<Int>
) {

    // OTHER
    val textMeasurer = rememberTextMeasurer()
    val labelStyle = Design.typography.Body2.copy(color = Design.colors.content, fontWeight = FontWeight.Bold)
    val dayStyle = Design.typography.Body.copy(color = Design.colors.content)
    val radius = 10.dp
    val backgroundMain = Design.colors.secondary
    val backgroundHeader = Design.colors.accent_primary
    val selectedColor = Design.colors.accent_secondary
    val weekDayLabelHeight = 24.dp

    // CALENDAR UTILS
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val daysInMonth = getDaysInMonth(month, year)
    val firstDayOfMonth = firstDayOfMonth(month, year)
    val padding = Design.dp.padding

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {
        TextFieldH2(
            text = monthTitle(month),
            fontWeight = FontWeight.Bold
        )

        Canvas(modifier = Modifier.fillMaxSize()) {

            val labelsHeight = ceil((padding + weekDayLabelHeight).toPx())
            val dayWidth = (size.width - padding.toPx() - padding.toPx()) / 7f
            val dayHeight = (size.height - labelsHeight - padding.toPx() - padding.toPx() - padding.toPx()) / 5f

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
                            size = Size(size.width, labelsHeight)
                        ),
                        topLeft = CornerRadius(radius.toPx(), radius.toPx()),
                        topRight = CornerRadius(radius.toPx(), radius.toPx()),
                    )
                )
            }
            drawPath(path, color = backgroundHeader)

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
                val x = column * dayWidth + padding.toPx()
                val y = (row * dayHeight) + labelsHeight + (padding.toPx() / 2)

                val innerBackgroundPadding = 6

                listOfValues
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