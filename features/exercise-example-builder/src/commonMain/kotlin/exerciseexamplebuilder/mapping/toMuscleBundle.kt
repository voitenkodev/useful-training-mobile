package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.Muscle

internal fun Muscle.toDomain(): models.Muscle {
    return models.Muscle(
        id = id,
        name = name,
        muscleTypeId = muscleTypeId
    )
}