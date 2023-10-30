package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.Muscle

internal fun Muscle.toDomain() = models.Muscle(
    id = id,
    name = name,
)