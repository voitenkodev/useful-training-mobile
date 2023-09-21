package trainings

import DateTimeKtx
import androidx.compose.runtime.Immutable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.datetime.LocalDateTime
import training.Training

@Parcelize
@Immutable
data class TrainingsState(
    val weekDay: String = DateTimeKtx.currentWeekDay(),
    val date: String = DateTimeKtx.currentDate(),

    val trainings: List<Training> = emptyList(),
    val calendar: List<SelectableCalendar> = emptyList(),

    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

@Parcelize
@Immutable
data class SelectableCalendar(
    val isSelected: Boolean,
    val dateTimeIso: String,
    val day: String,
    val weekDay: String,
) : Parcelable