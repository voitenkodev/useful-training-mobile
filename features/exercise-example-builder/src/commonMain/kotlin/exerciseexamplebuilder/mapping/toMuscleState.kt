package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.Muscle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.Muscle>.toState(): ImmutableList<Muscle> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name,
        muscleTypeId = muscleTypeId
    )
}