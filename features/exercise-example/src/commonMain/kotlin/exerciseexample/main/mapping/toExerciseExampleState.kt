package exerciseexample.main.mapping

import exerciseexample.main.models.ExerciseExample

internal fun models.ExerciseExample.toState(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name,
        description = description,
        imageUrl = imageUrl,
        muscleExerciseBundles = muscleExerciseBundles.toState()
    )
}