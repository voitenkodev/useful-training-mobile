package statistics.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class Interval(
    val isSelected: Boolean = false,
    val type: IntervalType
)

@Immutable
internal enum class IntervalType(val title: String) {
    LastWeek("Last Week"),
    LastMonth("Last Month"),
    LastYear("Last Year")
}