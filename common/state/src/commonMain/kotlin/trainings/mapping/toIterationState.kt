package trainings.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import toDoubleOrIntString
import trainings.Iteration

public fun List<models.Iteration>.toState(): ImmutableList<Iteration> {
    return map { it.toState() }
        .toImmutableList()
}

public fun models.Iteration.toState(): Iteration {
    return Iteration(
        weightAndRepeat = buildString {
            append(weight.toDoubleOrIntString())
            append(" x ")
            append(repetitions.toString())
        }
    )
}