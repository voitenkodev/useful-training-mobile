package profile.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import profile.state.Muscle

internal fun List<models.Muscle>.toState(): ImmutableList<Muscle> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}