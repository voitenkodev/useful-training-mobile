package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.ExerciseExample

internal fun models.ExerciseExample.toState(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        muscleExerciseBundles = muscleExerciseBundles.toState()
    )
}