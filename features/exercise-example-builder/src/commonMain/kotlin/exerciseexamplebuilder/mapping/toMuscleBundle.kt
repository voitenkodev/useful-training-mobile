package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.Muscle
import models.MuscleEnum

internal fun Muscle.toDomain(): models.Muscle {
    return models.Muscle(
        id = id,
        name = name,
        muscleTypeId = muscleTypeId,
        type = MuscleEnum.UNKNOWN // TOOO FIX
    )
}