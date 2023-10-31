package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.MuscleExerciseBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.MuscleExerciseBundle>.toState(): ImmutableList<MuscleExerciseBundle> {
    return map { it.toState() }
        .toImmutableList()
}

internal fun models.MuscleExerciseBundle.toState(): MuscleExerciseBundle {
    return MuscleExerciseBundle(
        id = id,
        value = value,
        muscle = muscle.toState()
    )
}