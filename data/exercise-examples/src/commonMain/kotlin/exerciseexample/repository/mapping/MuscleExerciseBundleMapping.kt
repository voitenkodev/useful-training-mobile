package exerciseexample.repository.mapping

import models.MuscleExerciseBundle
import models.MuscleExerciseBundleDto

// _______ NETWORK _______

internal fun List<MuscleExerciseBundleDto>.dtoToDomain(): List<MuscleExerciseBundle> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun MuscleExerciseBundleDto.dtoToDomain(): MuscleExerciseBundle? {
    return MuscleExerciseBundle(
        id = id ?: return null,
        value = value ?: return null,
        muscle = muscle?.dtoToDomain() ?: return null
    )
}

// _______ DOMAIN _______

internal fun List<MuscleExerciseBundle>.domainToDto(): List<MuscleExerciseBundleDto> {
    return mapNotNull { it.domainToDto() }
}

internal fun MuscleExerciseBundle.domainToDto(): MuscleExerciseBundleDto {
    return MuscleExerciseBundleDto(
        id = id,
        muscle = muscle.domainToDto(),
        muscleId = muscle.id,
        value = value
    )
}