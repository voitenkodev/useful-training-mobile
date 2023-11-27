package trainings.list.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import toDoubleOrIntString
import trainings.list.state.Iteration

internal fun List<models.Iteration>.toState(): ImmutableList<Iteration> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.Iteration.toState(): Iteration {
    return Iteration(
        weightAndRepeat = buildString {
            append(weight.toDoubleOrIntString())
            append(" x ")
            append(repetitions.toString())
        }
    )
}