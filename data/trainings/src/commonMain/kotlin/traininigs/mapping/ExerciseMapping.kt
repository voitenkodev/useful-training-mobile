package traininigs.mapping

import models.Exercise
import models.ExerciseDto
import models.Iteration
import models.IterationDto

internal fun ExerciseDto.toDomain(iterations: List<Iteration>): Exercise? {
    return Exercise(
        id = id,
        name = name ?: return null,
        tonnage = tonnage ?: return null,
        countOfLifting = countOfLifting ?: return null,
        intensity = intensity ?: return null,
        iterations = iterations
    )
}

internal fun ExerciseDao.toDomain(iterations: List<Iteration>): Exercise? {
    return Exercise(
        id = id,
        name = name ?: return null,
        tonnage = tonnage ?: return null,
        countOfLifting = countOfLifting ?: return null,
        intensity = intensity ?: return null,
        iterations = iterations
    )
}

internal fun Exercise.toDto(iterations: List<IterationDto>): ExerciseDto {
    return ExerciseDto(
        id = id,
        name = name,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}

internal fun ExerciseDto.toDao(iterations: List<IterationDao>): ExerciseDao {
    return ExerciseDao(
        id = id,
        name = name,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}