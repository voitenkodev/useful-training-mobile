package presentation.state

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import utils.DateTimeKtx

@Serializable
@Parcelize
data class ShortTrainingState(
    val id: String?,
    val exercises: List<String> = emptyList(),
    val startDateTime: String,
    val duration: String?,
) : Parcelable {
    val weekDay: String
        get() = DateTimeKtx().formattedWeekDay(startDateTime) ?: ""
    val startDate: String
        get() = DateTimeKtx().formattedLongDate(startDateTime) ?: ""
}