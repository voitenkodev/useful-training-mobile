package data.muscles.mapping

import models.Muscle
import models.MuscleEnum
import models.StatusEnum
import muscles.models.MuscleDao
import network.models.MuscleDto

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
        muscleGroupId = muscleGroupId ?: return null,
        type = type ?: return null,
        status = status
    )
}

internal fun MuscleDto.dtoToDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null,
        type = MuscleEnum.of(type ?: return null),
        status = StatusEnum.of(status)
    )
}

internal fun Muscle.domainToDto(): MuscleDto {
    return MuscleDto(
        id = id
    )
}