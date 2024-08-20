package exercise.mapping

import exercise.ExerciseExampleBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import muscles.mapping.toState

public fun List<models.ExerciseExampleBundle>.toState(): ImmutableList<ExerciseExampleBundle> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

public fun models.ExerciseExampleBundle.toState(): ExerciseExampleBundle? {
    return ExerciseExampleBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.toState(isSelected = false) ?: return null
    )
}