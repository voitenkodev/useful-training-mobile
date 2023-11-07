package traininig_exercise_iteration.mapping

import data.Exercise
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao

internal fun Exercise.toDao(iterations: List<IterationDao>): ExerciseDao {
    return ExerciseDao(
        id = id,
        trainingId = trainingId,
        name = name ?: "",
        volume = volume ?: 0.0,
        repetitions = repetitions?.toInt() ?: 0,
        intensity = intensity ?: 0.0,
        iterations = iterations,
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: ""
    )
}