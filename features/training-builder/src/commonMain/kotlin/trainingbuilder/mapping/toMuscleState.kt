package trainingbuilder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.state.Muscle

internal fun List<models.Muscle>.toState(): ImmutableList<Muscle> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        name = name,
        id = id
    )
}