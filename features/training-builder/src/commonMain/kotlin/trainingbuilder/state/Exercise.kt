package trainingbuilder.state

import androidx.compose.runtime.Immutable
import createId

@Immutable
internal data class Exercise(
    val id: String = createId(),
    val name: String = "",
    val iterations: List<Iteration> = listOf(Iteration()),
    val tonnage: Double = 0.0,
    val countOfLifting: Int = 0,
    val intensity: Double = 0.0
)