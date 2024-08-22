package trainingbuilder.training_builder.mapping

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import trainingbuilder.training_builder.models.BuildIteration

internal fun List<models.Iteration>.toState(): PersistentList<BuildIteration> {
    return map {
        it.toState()
    }.toPersistentList()
}

internal fun models.Iteration.toState() = BuildIteration(
    weight = weight.toDoubleOrIntString(),
    repetitions = repetitions.toString()
)
