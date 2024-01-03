package data.muscles.mapping

import exercise_example_muscle.models.MuscleTypeDao
import models.MuscleType
import models.MuscleTypeEnum
import network.models.MuscleTypeDto

internal fun List<MuscleTypeDao>.daoToDomain(): List<MuscleType> {
    return mapNotNull { it.daoToDomain() }
}

internal fun MuscleTypeDao.daoToDomain(): MuscleType {
    return MuscleType(
        id = id,
        name = name,
        muscles = muscles.daoToDomain(),
        type = MuscleTypeEnum.of(type)
    )
}

internal fun List<MuscleTypeDto>.dtoToDao(): List<MuscleTypeDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun MuscleTypeDto.dtoToDao(): MuscleTypeDao? {
    return MuscleTypeDao(
        id = id ?: return null,
        name = name ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        muscles = muscles?.dtoToDao() ?: emptyList(),
        type = type ?: return null
    )
}