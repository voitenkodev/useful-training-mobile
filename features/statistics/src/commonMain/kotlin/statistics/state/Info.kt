package statistics.state

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

}