package exercise_example_muscle.mapping

import data.GetMusclesById
import exercise_example_muscle.models.MuscleDao

internal fun GetMusclesById.mapToDao(): MuscleDao {
    return MuscleDao(
        id = id,
        name = name,
        type = type,
        muscleTypeId = muscleTypeId,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}