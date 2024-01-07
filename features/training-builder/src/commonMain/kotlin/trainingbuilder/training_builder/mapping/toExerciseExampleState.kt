package trainingbuilder.training_builder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import trainingbuilder.training_builder.models.ExerciseExample

internal fun List<models.ExerciseExample>.toState(): ImmutableList<ExerciseExample> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.ExerciseExample.toState(): ExerciseExample? {
    return ExerciseExample(
        id = id,
        name = name,
        imageUrl = imageUrl,
        exerciseExampleBundles = exerciseExampleBundles.toState()
    )
}