package utils

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration

internal object DateTimeKtx {

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
     * Output Output 23 October 2022
     * */
    fun currentDate(): String? {

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
     * Input 1h 44m 4.875s
     *
     * Output 01h 44m
     * */

    fun formattedDuration(duration: String): String? {
        return Duration.parseOrNull(duration)?.toComponents { hours, minutes, _, _ ->
            timeFormat(hours.toInt(), minutes)
        }
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