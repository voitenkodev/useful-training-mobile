package exerciseexamples.repository.mapping

import exercise_example_muscle.models.MuscleExerciseBundleDao
import models.MuscleExerciseBundle
import models.MuscleExerciseBundleDto

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

internal fun List<MuscleExerciseBundleDto>.dtoToDao(): List<MuscleExerciseBundleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun MuscleExerciseBundleDto.dtoToDao(): MuscleExerciseBundleDao? {
    return MuscleExerciseBundleDao(
        id = id ?: return null,
        value = value ?: return null,
        muscle = muscle?.dtoToDao() ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        muscleId = muscleId ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null
    )
}

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