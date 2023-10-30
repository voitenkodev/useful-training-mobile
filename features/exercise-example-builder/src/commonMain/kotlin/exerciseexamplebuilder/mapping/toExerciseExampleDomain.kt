package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.ExerciseExample

internal fun ExerciseExample.toDomain() = models.ExerciseExample(
    id = id,
    name = name,
    muscleExerciseBundles = muscleExerciseBundles.toDomain()
)