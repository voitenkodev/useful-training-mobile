package trainings.state

import androidx.compose.runtime.Immutable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
@Immutable
internal data class SelectableCalendar(
    val isSelected: Boolean,
    val isToday: Boolean,
    val dateTimeIso: String,
    val day: String,
    val weekDay: String,
    val countOfTrainings: Int
) : Parcelable