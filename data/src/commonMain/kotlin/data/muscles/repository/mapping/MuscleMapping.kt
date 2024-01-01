package data.muscles.repository.mapping

import exercise_example_muscle.models.MuscleDao
import models.Muscle
import models.MuscleDto
import models.MuscleEnum
import models.StatusEnum

internal fun List<MuscleDao>.daoToDomain(): List<Muscle> {
    return mapNotNull { it.daoToDomain() }
        .sortedBy { it.status }
}

internal fun MuscleDao.daoToDomain(): Muscle {
    return Muscle(
        id = id,
        name = name,
        type = MuscleEnum.of(type),
        status = StatusEnum.of(status)
    )
}

internal fun List<MuscleDto>.dtoToDao(): List<MuscleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun MuscleDto.dtoToDao(): MuscleDao? {
    return MuscleDao(
        id = id ?: return null,
        name = name ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        muscleTypeId = muscleTypeId ?: return null,
        type = type ?: return null,
        status = status
    )
}

internal fun MuscleDto.dtoToDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null,
        type = MuscleEnum.of(type ?: return null),
        status = StatusEnum.of(status ?: return null)
    )
}

internal fun Muscle.domainToDto(): MuscleDto {
    return MuscleDto(
        id = id
    )
}