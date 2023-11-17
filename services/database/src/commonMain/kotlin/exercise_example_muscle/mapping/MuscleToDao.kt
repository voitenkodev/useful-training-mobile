package exercise_example_muscle.mapping

import data.Muscle
import exercise_example_muscle.models.MuscleDao

internal fun Muscle.toDao(): MuscleDao {
    return MuscleDao(
        id = id,
        name = name,
        type = type,
        muscleTypeId = muscleTypeId,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}