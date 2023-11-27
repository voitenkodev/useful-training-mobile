package trainings.list.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class SelectableCalendar(
    val isSelected: Boolean,
    val isToday: Boolean,
    val dateTimeIso: String,
    val day: String,
    val weekDay: String,
    val repetitions: Int
)