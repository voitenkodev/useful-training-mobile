package configurations.mapping

import configurations.state.ExerciseExample
import kotlinx.collections.immutable.toImmutableList

internal fun List<ExerciseExample>.toDomain() = this
    .map { it.toDomain() }
    .toImmutableList()

internal fun ExerciseExample.toDomain() = models.ExerciseExample(
    id = id,
    name = name,
)