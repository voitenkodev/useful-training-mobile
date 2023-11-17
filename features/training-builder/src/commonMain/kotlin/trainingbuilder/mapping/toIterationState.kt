package trainingbuilder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import trainingbuilder.state.Iteration

internal fun List<models.Iteration>.toState(): ImmutableList<Iteration> {
    return map {
        it.toState()
    }.toPersistentList()
}

internal fun models.Iteration.toState() = Iteration(
    weight = weight.toDoubleOrIntString(),
    repetitions = repetitions.toString()
)
