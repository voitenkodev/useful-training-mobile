package exercise.mapping

import exercise.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

public fun List<models.ExerciseExample>.toState(): ImmutableList<ExerciseExample> {
    return map { it.toState() }
        .toImmutableList()
}

public fun models.ExerciseExample.toState(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        imageUrl = imageUrl,
        exerciseExampleBundles = exerciseExampleBundles.toState(),
    )
}