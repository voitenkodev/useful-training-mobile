package exerciseexamples.mapping

import exerciseexamples.state.MuscleExerciseBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.MuscleExerciseBundle>.toState(): ImmutableList<MuscleExerciseBundle> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.MuscleExerciseBundle.toState(): MuscleExerciseBundle? {
    return MuscleExerciseBundle(
        id = id ?: return null,
        percentage = percentage,
        muscle = muscle.toState()
    )
}