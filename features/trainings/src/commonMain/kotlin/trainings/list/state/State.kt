package trainings.list.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val trainings: ImmutableList<Training> = persistentListOf(),
    val displayedTrainings: ImmutableList<Training> = persistentListOf(),
    val calendar: ImmutableList<SelectableCalendar> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
