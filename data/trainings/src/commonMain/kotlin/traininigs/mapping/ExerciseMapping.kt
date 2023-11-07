package traininigs.mapping

import models.Exercise
import models.ExerciseDto
import models.Iteration
import models.IterationDto
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao

internal fun ExerciseDto.toDomain(iterations: List<Iteration>): Exercise? {
    return Exercise(
        id = id,
        name = name ?: return null,
        volume = volume ?: return null,
        countOfLifting = countOfLifting ?: return null,
        intensity = intensity ?: return null,
        iterations = iterations
    )
}

internal fun ExerciseDao.toDomain(iterations: List<Iteration>): Exercise {
    return Exercise(
        id = id,
        name = name,
        volume = volume,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}

internal fun Exercise.dtoToDto(iterations: List<IterationDto>): ExerciseDto {
    return ExerciseDto(
        id = id,
        name = name,
        volume = volume,
        countOfLifting = countOfLifting,
        intensity = intensity,
        iterations = iterations
    )
}

internal fun ExerciseDto.dtoToDao(iterations: List<IterationDao>): ExerciseDao? {
    return ExerciseDao(
        id = id ?: return null,
        name = name ?: return null,
        volume = volume ?: return null,
        countOfLifting = countOfLifting ?: return null,
        intensity = intensity ?: return null,
        iterations = iterations,
        updatedAt = updatedAt ?: return null,
        createdAt = createdAt ?: return null,
        trainingId = trainingId ?: return null
    )
}