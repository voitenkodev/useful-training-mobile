package musclepicker.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import musclepicker.state.Muscle

internal fun List<models.Muscle>.toState(): ImmutableList<Muscle> {
    return map { it.toState() }
        .toPersistentList()
}

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        name = name,
        id = id,
        isSelected = false
    )
}