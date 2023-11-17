package exercise_example_muscle.mapping

import data.MuscleType
import exercise_example_muscle.models.MuscleDao
import exercise_example_muscle.models.MuscleTypeDao

internal fun MuscleType.toDao(muscles: List<MuscleDao>): MuscleTypeDao {
    return MuscleTypeDao(
        id = id,
        name = name,
        muscles = muscles,
        type = type,
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: ""
    )
}