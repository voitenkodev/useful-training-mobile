package trainingbuilder.builder.mapping

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import trainingbuilder.builder.state.Iteration

internal fun List<models.Iteration>.toState(): PersistentList<Iteration> {
    return map {
        it.toState()
    }.toPersistentList()
}

internal fun models.Iteration.toState() = Iteration(
    weight = weight.toDoubleOrIntString(),
    repetitions = repetitions.toString()
)
