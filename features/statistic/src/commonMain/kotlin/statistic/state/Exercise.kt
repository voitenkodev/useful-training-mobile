package statistic.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class Exercise(
    val id: String,
    val name: String = "",
    val iterations: List<Iteration> = emptyList(),
    val tonnage: Double = 0.0,
)