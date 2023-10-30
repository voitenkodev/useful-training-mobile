package configurations.mapping

import configurations.state.ExerciseExample

internal fun ExerciseExample.toDomain() = models.ExerciseExample(
    id = id,
    name = name,
)