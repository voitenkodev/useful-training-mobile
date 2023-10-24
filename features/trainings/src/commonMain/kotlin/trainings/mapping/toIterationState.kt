package trainings.mapping

import kotlinx.collections.immutable.toImmutableList
import toDoubleOrIntString
import trainings.state.Iteration

internal fun List<models.Iteration>.toState() = this
    .map { it.toState() }
    .toImmutableList()

internal fun models.Iteration.toState() = Iteration(
    weightAndRepeat = buildString {
        append(weight?.toDoubleOrIntString() ?: "")
        append(" x ")
        append(repeat?.toString() ?: "")
    }
)
