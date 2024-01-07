package data.muscles.mapping

import models.MuscleGroup
import models.MuscleGroupEnum
import muscles.models.MuscleGroupDao
import network.models.MuscleGroupDto

internal fun List<MuscleGroupDao>.daoToDomain(): List<MuscleGroup> {
    return mapNotNull { it.daoToDomain() }
}

internal fun MuscleGroupDao.daoToDomain(): MuscleGroup {
    return MuscleGroup(
        id = id,
        name = name,
        muscles = muscles.daoToDomain(),
        type = MuscleGroupEnum.of(type)
    )
}

internal fun List<MuscleGroupDto>.dtoToDao(): List<MuscleGroupDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun MuscleGroupDto.dtoToDao(): MuscleGroupDao? {
    return MuscleGroupDao(
        id = id ?: return null,
        name = name ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        muscles = muscles?.dtoToDao() ?: emptyList(),
        type = type ?: return null
    )
}