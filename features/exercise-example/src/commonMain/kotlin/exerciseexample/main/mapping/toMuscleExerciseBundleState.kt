package exerciseexample.main.mapping

import exerciseexample.main.models.ExerciseExampleBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.ExerciseExampleBundle>.toState(): ImmutableList<ExerciseExampleBundle> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.ExerciseExampleBundle.toState(): ExerciseExampleBundle? {
    return ExerciseExampleBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.toState() ?: return null
    )
}