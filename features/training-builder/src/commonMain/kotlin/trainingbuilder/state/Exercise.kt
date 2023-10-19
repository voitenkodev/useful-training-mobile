package trainingbuilder.state

import androidx.compose.runtime.Immutable
import com.benasher44.uuid.uuid4

@Immutable
internal data class Exercise(
    val id: String = uuid4().toString(),
    val name: String = "",
    val iterations: List<Iteration> = listOf(Iteration()),
    val tonnage: Double = 0.0,
    val countOfLifting: Int = 0,
    val intensity: Double = 0.0
)