package trainings.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val trainings: List<Training> = emptyList(),
    val calendar: List<SelectableCalendar> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false
)
