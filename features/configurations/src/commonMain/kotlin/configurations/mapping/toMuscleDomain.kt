package configurations.mapping

import configurations.state.Muscle
import kotlinx.collections.immutable.toImmutableList

internal fun List<Muscle>.toDomain() = this
    .map { it.toDomain() }
    .toImmutableList()

internal fun Muscle.toDomain() = models.Muscle(
    id = id,
    name = name,
)