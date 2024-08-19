package trainings.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import trainings.Training
import trainings.main.models.SelectableCalendar

@Immutable
internal data class State(
    val trainings: ImmutableList<Training> = persistentListOf(),
    val displayedTrainings: ImmutableList<Training> = persistentListOf(),
    val calendar: ImmutableList<SelectableCalendar> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
