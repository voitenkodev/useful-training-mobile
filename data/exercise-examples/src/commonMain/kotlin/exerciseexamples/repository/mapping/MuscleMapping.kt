package exerciseexamples.repository.mapping

import models.Muscle
import models.MuscleDto

internal fun List<MuscleDto>.dtoToDomain(): List<Muscle> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun MuscleDto.dtoToDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null
    )
}

internal fun Muscle.domainToDto(): MuscleDto {
    return MuscleDto(
        id = id,
        name = name
    )
}