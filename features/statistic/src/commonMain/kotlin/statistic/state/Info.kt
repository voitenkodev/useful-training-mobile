package statistic.state

import DateTimeKtx
import androidx.compose.runtime.Immutable

@Immutable
internal data class Info(
    val trainingId: String? = null,
    val date: String,
) {
    val weekDay: String
        get() = DateTimeKtx.formattedWeekDay(date) ?: ""
    val dateTime: String
        get() = DateTimeKtx.formattedDateTime(date) ?: ""
    val day: Int
        get() = DateTimeKtx.formattedRealMonthDay(date) ?: -1
    val month: Int
        get() = DateTimeKtx.formattedRealMonthNum(date) ?: -1
    val year: Int
        get() = DateTimeKtx.formattedYear(date) ?: -1
}