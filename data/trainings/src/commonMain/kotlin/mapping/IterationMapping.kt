package mapping

import models.Iteration
import traininig_exercise_iteration.models.IterationDao
import models.IterationDto

internal fun IterationDto.toDomain(): Iteration {
    return Iteration(
        id = this.id,
        weight = this.weight,
        repeat = this.repeat
    )
}

internal fun IterationDao.toDomain(): Iteration {
    return Iteration(
        id = this.id,
        weight = this.weight,
        repeat = this.repeat
    )
}

internal fun IterationDto.toDao(): IterationDao {
    return IterationDao(
        id = this.id,
        weight = this.weight,
        repeat = this.repeat
    )
}

internal fun Iteration.toDto(): IterationDto {
    return IterationDto(
        id = this.id,
        weight = this.weight,
        repeat = this.repeat
    )
}
