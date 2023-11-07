package trainingbuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class Exercise(
    val id: String? = null,
    val name: String = "",
    val iterations: List<Iteration> = listOf(Iteration()),
    val volume: Double = 0.0,
    val repetitions: Int = 0,
    val intensity: Double = 0.0
)