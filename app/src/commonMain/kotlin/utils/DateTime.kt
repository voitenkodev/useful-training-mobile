package utils

import kotlinx.datetime.*

class DateTimeKtx {

    fun currentTime(): String {
        return Clock.System.now().toString()
    }

    fun getFormattedDate(
        iso8601Timestamp: String,
    ): String {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp)
        val date = localDateTime.date
        val day = date.dayOfMonth
        val month = date.monthNumber
        val year = date.year

        return "${day.zeroPrefixed(2)}.${month.zeroPrefixed(2)}.${year}"
    }

    fun getFormattedTime(iso8601Timestamp: String): String {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp)
        val hour = localDateTime.hour
        val min = localDateTime.minute

        return "${hour.zeroPrefixed(2)}:${min.zeroPrefixed(2)}"
    }

    fun getFormattedWeekDay(iso8601Timestamp: String): String {
        val localDateTime = iso8601TimestampToLocalDateTime(iso8601Timestamp)
        val dayOfWeek = localDateTime.dayOfWeek.name

        return dayOfWeek
    }

    private fun iso8601TimestampToLocalDateTime(timestamp: String): LocalDateTime {
        return Instant.parse(timestamp).toLocalDateTime(TimeZone.currentSystemDefault())
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