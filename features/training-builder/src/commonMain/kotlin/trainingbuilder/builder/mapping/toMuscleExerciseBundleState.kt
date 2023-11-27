package trainingbuilder.builder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import trainingbuilder.builder.state.MuscleExerciseBundle

internal fun List<models.MuscleExerciseBundle>.toState(): ImmutableList<MuscleExerciseBundle> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.MuscleExerciseBundle.toState(): MuscleExerciseBundle? {
    return MuscleExerciseBundle(
        id = id ?: return null,
        percentage = percentage,
        muscle = muscle?.toState() ?: return null
    )
}