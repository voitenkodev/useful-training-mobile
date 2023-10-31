package statistics.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import statistics.state.Iteration
import toDoubleOrIntString

internal fun List<models.Iteration>.toState(): ImmutableList<Iteration> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.Iteration.toState(): Iteration {
    return Iteration(
        weightAndRepeat = buildString {
            append(weight.toDoubleOrIntString())
            append(" x ")
            append(repeat.toString())
        }
    )
}