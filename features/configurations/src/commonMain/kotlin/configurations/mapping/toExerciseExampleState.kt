package configurations.mapping

import configurations.state.ExerciseExample
import kotlinx.collections.immutable.toImmutableList

internal fun List<models.ExerciseExample>.toState() = this
    .mapNotNull { it.toState() }
    .toImmutableList()

internal fun models.ExerciseExample.toState(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name
    )
}