package configurations.mapping

import configurations.state.ExerciseExample
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.ExerciseExample>.toState() = this
    .map { it.toState() }
    .toImmutableList()

internal fun models.ExerciseExample.toState() = ExerciseExample(
    id = id,
    name = name,
)