package searchexercise.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import searchexercise.main.models.ExerciseExample

internal fun List<models.ExerciseExample>.toState(): ImmutableList<ExerciseExample> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.ExerciseExample.toState(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        imageUrl = imageUrl,
        exerciseExampleBundles = exerciseExampleBundles.toState(),
    )
}