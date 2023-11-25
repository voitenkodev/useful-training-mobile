package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.MuscleExerciseBundle

internal fun List<MuscleExerciseBundle>.toDomain(): List<models.MuscleExerciseBundle> {
    return map { it.toDomain() }
}

internal fun MuscleExerciseBundle.toDomain(): models.MuscleExerciseBundle {
    return models.MuscleExerciseBundle(
        id = id,
        percentage = percentage,
        muscleId = muscle.id,
        muscle = null // do not need to send to BE, just ID
    )
}