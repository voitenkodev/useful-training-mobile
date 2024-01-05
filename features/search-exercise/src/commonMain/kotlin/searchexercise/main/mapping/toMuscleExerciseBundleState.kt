package searchexercise.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import searchexercise.main.models.MuscleExerciseBundle

internal fun List<models.MuscleExerciseBundle>.toState(): ImmutableList<MuscleExerciseBundle> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.MuscleExerciseBundle.toState(): MuscleExerciseBundle {
    return MuscleExerciseBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.toState()
    )
}