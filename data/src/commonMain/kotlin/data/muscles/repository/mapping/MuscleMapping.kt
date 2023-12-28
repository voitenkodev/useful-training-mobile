package data.muscles.repository.mapping

import exercise_example_muscle.models.MuscleDao
import models.Muscle
import models.MuscleDto
import models.MuscleEnum
import models.PriorityEnum

internal fun List<MuscleDao>.daoToDomain(): List<Muscle> {
    return mapNotNull { it.daoToDomain() }
        .sortedBy { it.priority }
}

internal fun MuscleDao.daoToDomain(): Muscle {
    return Muscle(
        id = id,
        name = name,
        type = MuscleEnum.of(type),
        status = status,
        priority = PriorityEnum.entries.toTypedArray().random() // TODO HARDCODE
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
        status = status ?: return null
    )
}

internal fun MuscleDto.dtoToDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null,
        type = MuscleEnum.of(type ?: return null),
        status = status ?: return null,
        priority = PriorityEnum.Medium
    )
}

internal fun Muscle.domainToDto(): MuscleDto {
    return MuscleDto(
        id = id
    )
}