package exerciseexamples.edit.mapping

import exerciseexamples.edit.state.ExerciseExample

internal fun models.ExerciseExample.toState(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name
    )
}