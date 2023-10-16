package mappers

import data.Exercise
import models.ExerciseDao
import models.IterationDao

internal fun Exercise.toDao(iterations: List<IterationDao>): ExerciseDao {
    return ExerciseDao(
        id = this.id,
        name = this.name,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting?.toInt(),
        intensity = this.intensity,
        iterations = iterations
    )
}