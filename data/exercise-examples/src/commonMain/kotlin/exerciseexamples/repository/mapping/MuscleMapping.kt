package exerciseexamples.repository.mapping

import exercise_example_muscle.models.MuscleDao
import models.Muscle
import models.MuscleDto
import models.MuscleEnum

internal fun List<MuscleDao>.daoToDomain(): List<Muscle> {
    return mapNotNull { it.daoToDomain() }
        .sortedByDescending { it.name.length }
}

internal fun MuscleDao.daoToDomain(): Muscle {
    return Muscle(
        id = id,
        name = name,
        type = MuscleEnum.of(type)
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
        type = type ?: return null
    )
}

internal fun Muscle.domainToDto(): MuscleDto {
    return MuscleDto(
        id = id
    )
}