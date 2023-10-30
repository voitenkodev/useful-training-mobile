package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.MuscleExerciseBundle

internal fun List<MuscleExerciseBundle>.toDomain() = this
    .map { it.toDomain() }

internal fun MuscleExerciseBundle.toDomain() = models.MuscleExerciseBundle(
    id = id,
    value = value,
    muscle = muscle.toDomain()
)