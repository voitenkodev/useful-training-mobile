package statistic.mapping

import statistic.state.Iteration
import toDoubleOrIntString

internal fun List<models.Iteration>.toIterationStateList() = this.map { it.toIterationState() }

internal fun models.Iteration.toIterationState() = Iteration(
    weightAndRepeat = buildString {
        append(weight?.toDoubleOrIntString() ?: "")
        append(" x ")
        append(repeat?.toString() ?: "")
    }
)
