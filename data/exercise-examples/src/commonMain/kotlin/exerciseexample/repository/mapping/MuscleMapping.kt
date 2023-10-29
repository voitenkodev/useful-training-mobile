package exerciseexample.repository.mapping

import exercise_example_muscle.models.MuscleDao
import models.Muscle
import models.MuscleDto

// _______ NETWORK _______

internal fun List<MuscleDto>.dtoToDomain(): List<Muscle> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun MuscleDto.dtoToDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null
    )
}

// _______ DATABASE _______

internal fun List<MuscleDao>.daoToDomain(): List<Muscle> {
    return mapNotNull { it.daoToDomain() }
}

internal fun MuscleDao.daoToDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null
    )
}

// _______ DOMAIN _______

internal fun List<Muscle>.domainToDao(): List<MuscleDao> {
    return mapNotNull { it.domainToDao() }
}

internal fun Muscle.domainToDao(): MuscleDao {
    return MuscleDao(
        id = id,
        name = name
    )
}

internal fun List<Muscle>.domainToDto(): List<MuscleDto> {
    return mapNotNull { it.domainToDto() }
}

internal fun Muscle.domainToDto(): MuscleDto {
    return MuscleDto(
        id = id,
        name = name
    )
}