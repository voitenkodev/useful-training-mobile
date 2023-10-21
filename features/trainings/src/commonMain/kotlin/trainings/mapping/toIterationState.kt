package trainings.mapping

import kotlinx.collections.immutable.toImmutableList
import toDoubleOrIntString
import trainings.state.Iteration

internal fun List<models.Iteration>.toIterationStateList() = this
    .map { it.toIterationState() }
    .toImmutableList()

internal fun models.Iteration.toIterationState() = Iteration(
    weightAndRepeat = buildString {
        append(weight?.toDoubleOrIntString() ?: "")
        append(" x ")
        append(repeat?.toString() ?: "")
    }
)
