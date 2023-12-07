package data.traininigs.mapping

import models.Iteration
import models.IterationDto
import traininig_exercise_iteration.models.IterationDao

internal fun IterationDao.toDomain(): Iteration {
    return Iteration(
        id = id,
        weight = weight,
        repetitions = repetitions
    )
}

internal fun IterationDto.dtoToDao(): IterationDao? {
    return IterationDao(
        id = id ?: return null,
        weight = weight ?: return null,
        repetitions = repetitions ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        exerciseId = exerciseId ?: return null
    )
}

internal fun Iteration.dtoToDto(): IterationDto {
    return IterationDto(
        id = id,
        weight = weight,
        repetitions = repetitions
    )
}