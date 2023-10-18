import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration

object DateTimeKtx {

    /**
     * Input 2 + listOf(2022-10-21T13:20:18.496Z, 2022-10-22T13:20:18.496Z)
     * Output listOf(2022-10-20T13:20:18.496Z, 2022-10-19T13:20:18.496Z)
     **/

    fun addEarlyCalendarChunk(
        previousList: List<String>,
        count: Int,
    ): List<String> {
        val timeZone = TimeZone.currentSystemDefault()

        val lastDate = if (previousList.isEmpty()) Clock
            .System.now()
            .toLocalDateTime(timeZone)
            .toInstant(timeZone)
            .plus(4, DateTimeUnit.DAY, timeZone)
            .toLocalDateTime(timeZone)
        else previousList
            .minOfOrNull {
                Instant.parse(it)
                    .toLocalDateTime(timeZone)
            }

        if (lastDate == null) return emptyList()

        val newChunk = mutableListOf<String>()

        for (i in 1..count) {
            val previousDate = lastDate
                .toInstant(timeZone)
                .minus(i, DateTimeUnit.DAY, timeZone)
                .toLocalDateTime(timeZone)
                .toInstant(offset = UtcOffset.ZERO)
                .toString()

            newChunk.add(previousDate)
        }

        return newChunk.toSet().toList()
    }

    /**
     * Output 2022-10-21T13:20:18.496Z
     * */

    fun currentDateTime() = Clock.System.now().toString()

    /**
     * Output FRIDAY
     * */
    fun currentWeekDay(): String {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return localDateTime.dayOfWeek.name
    }

    /**
     * Output 23 October 2022
     * */
    fun currentDate(): String {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val date = localDateTime.date
        val day = date.dayOfMonth
        val month = date.month.name.lowercase().capitalize(Locale.current)
        val year = date.year
        return "${day.zeroPrefixed(2)} $month $year"
    }


    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output true / false
     * */

    fun isCurrentDate(iso8601Timestamp: String): Boolean {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp)?.date ?: return false
        val currentLocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        return localDateTime == currentLocalDateTime
    }

    /**
     * Input 2022-10-21T13:20:18.496Z ,  2022-10-21T13:20:18.496Z
     *
     * Output true / false
     * */
    fun isTheSameDate(iso8601Timestamp1: String, iso8601Timestamp2: String): Boolean {
        val localDateTime1 = iso8601TimestampToLocalDateTime(iso8601Timestamp1)?.date ?: return false
        val localDateTime2 = iso8601TimestampToLocalDateTime(iso8601Timestamp2)?.date ?: return false
        return localDateTime1 == localDateTime2
    }

    /**
     * Output 23
     * */
    fun currentRealMonthDay(): Int {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val date = localDateTime.date
        return date.dayOfMonth
    }

    /**
     * Output 10
     * p.s. from 0 to 11
     * */
    fun currentMonth(): Int {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return localDateTime.date.month.ordinal
    }

    /**
     * Output 10
     * p.s. from 1 to 12
     * */
    fun currentRealMonth(): Int {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return localDateTime.date.month.ordinal + 1
    }

    /**
     * Output 2023
     * */
    fun currentYear(): Int {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return localDateTime.date.year
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 2h 18m 12.066s
     * */

    fun durationFrom(iso8601Timestamp: String): String {
        val now: Instant = Clock.System.now()
        val result: Duration = (now - Instant.parse(iso8601Timestamp))
        return result.toString()
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 21.10.2022
     * */

    fun formattedShortDate(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        val date = localDateTime.date
        val day = date.dayOfMonth
        val month = date.monthNumber
        val year = date.year
        return "${day.zeroPrefixed(2)}.${month.zeroPrefixed(2)}.${year}"
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 21
     * */

    fun formattedDate(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        val date = localDateTime.date
        val day = date.dayOfMonth
        return day.zeroPrefixed(2)
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output Fri
     * */

    fun formattedDayOfWeek(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        val date = localDateTime.date
        return date.dayOfWeek.name.take(3)
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 21 October 2022
     * */

    fun formattedLongDate(iso8601Timestamp: String, withYear: Boolean = true): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        val date = localDateTime.date
        val day = date.dayOfMonth
        val month = date.month.name.lowercase().capitalize(Locale.current)
        val year = date.year

        return if (withYear) "${day.zeroPrefixed(2)} $month $year"
        else "${day.zeroPrefixed(2)} $month"
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 23 October 2022
     * */

    fun formattedEndOfWeekLongDate(iso8601Timestamp: String, withYear: Boolean = true): String? {
        val currentLocalDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null

        val dayOfWeek = DayOfWeek.values().lastIndex - currentLocalDateTime.dayOfWeek.ordinal

        val endOfWeek = currentLocalDateTime
            .toInstant(TimeZone.currentSystemDefault())
            .plus(dayOfWeek, DateTimeUnit.DAY, TimeZone.currentSystemDefault())
            .toString()

        return formattedLongDate(endOfWeek, withYear)
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 17 October 2022
     * */

    fun formattedStartOfWeekLongDate(
        iso8601Timestamp: String,
        withYear: Boolean = true
    ): String? {
        val currentLocalDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null

        val dayOfWeek = currentLocalDateTime.dayOfWeek.ordinal

        val endOfWeek = currentLocalDateTime
            .toInstant(TimeZone.currentSystemDefault())
            .minus(dayOfWeek, DateTimeUnit.DAY, TimeZone.currentSystemDefault())
            .toString()

        return formattedLongDate(endOfWeek, withYear)
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 17h 44m
     * */


    fun formattedTime(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        val hour = localDateTime.hour
        val min = localDateTime.minute
        return timeFormat(hour, min)
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 17h 44m 21.10.2022
     * */

    fun formattedDateTime(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        val hour = localDateTime.hour
        val min = localDateTime.minute

        val date = localDateTime.date
        val day = date.dayOfMonth
        val month = date.monthNumber
        val year = date.year
        return "${timeFormat(hour, min)} ${day.zeroPrefixed(2)}.${month.zeroPrefixed(2)}.${year}"
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output FRIDAY
     * */

    fun formattedWeekDay(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        return localDateTime.dayOfWeek.name
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 9
     * */

    fun formattedRealMonthDay(iso8601Timestamp: String): Int? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        return localDateTime.dayOfMonth
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 9
     * */

    fun formattedMonthNum(iso8601Timestamp: String): Int? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        return localDateTime.month.ordinal
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output October
     * */

    fun formattedMonth(iso8601Timestamp: String): String? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        return localDateTime.month.name
    }

    /**
     * Input 2022-10-21T13:20:18.496Z
     *
     * Output 10
     * */

    fun formattedRealMonthNum(iso8601Timestamp: String): Int? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        return localDateTime.month.ordinal + 1
    }

    /**
     * Input 2022
     *
     * Output 12
     * */

    fun formattedYear(iso8601Timestamp: String): Int? {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp) ?: return null
        return localDateTime.year
    }

    /**
     * Input 1h 44m 4.875s
     *
     * Output 01h 44m
     * */

    fun formattedDuration(duration: String): String? {
        return Duration.parseOrNull(duration)?.toComponents { hours, minutes, _, _ ->
            timeFormat(hours.toInt(), minutes)
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

    //___________________________ INTERNAL API ___________________________

    private fun iso8601TimestampToLocalDateTime(timestamp: String): LocalDateTime? {
        return kotlin.runCatching {
            Instant.parse(timestamp).toLocalDateTime(TimeZone.currentSystemDefault())
        }.getOrNull()
    }

    private fun timeFormat(
        hour: Int, min: Int
    ): String {
        return if (hour > 0 && min > 0) {
            "${hour.zeroPrefixed(2)}h ${min.zeroPrefixed(2)}m"
        } else if (hour > 0 && min == 0) {
            "${hour}h"
        } else if (hour == 0 && min > 0) {
            "${min}m"
        } else {
            ""
        }
    }

    private fun Int.zeroPrefixed(maxLength: Int): String {
        if (this < 0 || maxLength < 1) return ""
        val string = this.toString()
        val currentStringLength = string.length
        return if (maxLength <= currentStringLength) {
            string
        } else {
            val diff = maxLength - currentStringLength
            var prefixedZeros = ""
            repeat(diff) {
                prefixedZeros += "0"
            }
            "$prefixedZeros$string"
        }
    }
}