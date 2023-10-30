package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.ExerciseExample

internal fun models.ExerciseExample.toState() = ExerciseExample(
    id = id,
    name = name,
)