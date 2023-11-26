package exerciseexamples.mapping

import exerciseexamples.state.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.ExerciseExample>.toState(): ImmutableList<ExerciseExample> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.ExerciseExample.toState(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name,
        imageUrl = imageUrl,
        muscleExerciseBundles = muscleExerciseBundles.toState()
    )
}