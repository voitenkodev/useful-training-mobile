package configurations.mapping

import configurations.state.Muscle
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.Muscle>.toState() = this
    .map { it.toState() }
    .toImmutableList()

internal fun models.Muscle.toState() = Muscle(
    id = id,
    name = name,
)