package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.MuscleExerciseBundle
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.MuscleExerciseBundle>.toState() = this
    .map {
        it.toState()
    }.toImmutableList()

internal fun models.MuscleExerciseBundle.toState() = MuscleExerciseBundle(
    id = id,
    value = value,
    muscle = muscle.toState()
)