package traininig_exercise_iteration.mapping

import data.Iteration
import traininig_exercise_iteration.models.IterationDao

internal fun Iteration.toDao(): IterationDao {
    return IterationDao(
        id = id,
        weight = weight ?: 0.0,
        repeat = repeat?.toInt() ?: 0,
        exerciseId = exerciseId,
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: ""
    )
}