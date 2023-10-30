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

internal fun IterationDao.toDomain(): Iteration? {
    return Iteration(
        id = id,
        weight = weight ?: return null,
        repeat = repeat ?: return null
    )
}

internal fun IterationDto.toDao(): IterationDao {
    return IterationDao(
        id = id,
        weight = weight,
        repeat = repeat
    )
}

internal fun Iteration.toDto(): IterationDto {
    return IterationDto(
        id = id,
        weight = weight,
        repeat = repeat
    )
}
