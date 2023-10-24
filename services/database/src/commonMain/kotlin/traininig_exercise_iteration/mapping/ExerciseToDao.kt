package traininig_exercise_iteration.mapping

import data.Exercise
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao

internal fun Exercise.toDao(iterations: List<IterationDao>): ExerciseDao {
    return ExerciseDao(
        id = id,
        name = name,
        tonnage = tonnage,
        countOfLifting = countOfLifting?.toInt(),
        intensity = intensity,
        iterations = iterations
    )
}