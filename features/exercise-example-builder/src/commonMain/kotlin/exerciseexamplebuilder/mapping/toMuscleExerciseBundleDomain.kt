package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.MuscleExerciseBundle

internal fun List<MuscleExerciseBundle>.toDomain(): List<models.MuscleExerciseBundle> {
    return map { it.toDomain() }
}

internal fun MuscleExerciseBundle.toDomain(): models.MuscleExerciseBundle {
    return models.MuscleExerciseBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.toDomain()
    )
}