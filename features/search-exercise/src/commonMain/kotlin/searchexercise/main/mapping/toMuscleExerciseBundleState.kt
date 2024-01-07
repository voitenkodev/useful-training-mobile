package searchexercise.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import searchexercise.main.models.ExerciseExampleBundle

internal fun List<models.ExerciseExampleBundle>.toState(): ImmutableList<ExerciseExampleBundle> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.ExerciseExampleBundle.toState(): ExerciseExampleBundle {
    return ExerciseExampleBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.toState()
    )
}