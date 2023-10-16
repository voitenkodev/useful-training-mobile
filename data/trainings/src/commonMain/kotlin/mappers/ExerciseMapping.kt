package mappers

import models.Exercise
import models.ExerciseDao
import models.ExerciseDto
import models.Iteration
import models.IterationDao
import models.IterationDto

internal fun ExerciseDto.toDomain(
    iterations: List<Iteration>
): Exercise {
    return Exercise(
        id = id,
        name = name,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}

internal fun ExerciseDao.toDomain(
    iterations: List<Iteration>
): Exercise {
    return Exercise(
        id = id,
        name = name,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}

internal fun Exercise.toDto(
    iterations: List<IterationDto>
): ExerciseDto {
    return ExerciseDto(
        id = this.id,
        name = this.name,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting,
        intensity = this.intensity,
        iterations = iterations
    )
}

internal fun ExerciseDto.toDao(
    iterations: List<IterationDao>
): ExerciseDao {
    return ExerciseDao(
        id = id,
        name = name,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}