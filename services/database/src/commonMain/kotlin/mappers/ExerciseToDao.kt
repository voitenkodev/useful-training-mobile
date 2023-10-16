package mappers

import data.Exercise
import dto.backend.ExerciseDTO
import models.ExerciseDao
import models.IterationDao

internal fun Exercise.toDao(iterations: List<IterationDao>): ExerciseDao {
    return ExerciseDTO(
        id = this.id,
        name = this.name,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting?.toInt(),
        intensity = this.intensity,
        iterations = iterations
    )
}