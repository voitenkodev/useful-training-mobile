package traininigs.mapping

import models.Iteration
import models.IterationDto
import traininig_exercise_iteration.models.IterationDao

internal fun IterationDto.toDomain(): Iteration? {
    return Iteration(
        id = id,
        weight = weight ?: return null,
        repeat = repeat ?: return null
    )
}

internal fun IterationDao.toDomain(): Iteration {
    return Iteration(
        id = id,
        weight = weight,
        repeat = repeat
    )
}

internal fun IterationDto.dtoToDao(): IterationDao? {
    return IterationDao(
        id = id ?: return null,
        weight = weight ?: return null,
        repeat = repeat ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        exerciseId = exerciseId ?: return null
    )
}

internal fun Iteration.dtoToDto(): IterationDto {
    return IterationDto(
        id = id,
        weight = weight,
        repeat = repeat
    )
}