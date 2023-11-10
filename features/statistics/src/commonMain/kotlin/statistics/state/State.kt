package statistics.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    // Filters
    val query: String = "",
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),
    val muscles: ImmutableList<Muscle> = persistentListOf(),
    val intervals: ImmutableList<Interval> = persistentListOf(
        Interval(type = IntervalType.LastWeek, isSelected = true),
        Interval(type = IntervalType.LastMonth),
        Interval(type = IntervalType.LastYear)
    ),

    val filterPopupIsShowed: Boolean = false,

    val error: String? = null,
    val loading: Boolean = false
)
