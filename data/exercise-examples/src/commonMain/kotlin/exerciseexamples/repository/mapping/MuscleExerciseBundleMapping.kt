package exerciseexamples.repository.mapping

import exercise_example_muscle.models.MuscleExerciseBundleDao
import models.MuscleExerciseBundle
import models.MuscleExerciseBundleDto

internal fun List<MuscleExerciseBundleDao>.daoToDomain(): List<MuscleExerciseBundle> {
    return mapNotNull { it.daoToDomain() }
}

internal fun MuscleExerciseBundleDao.daoToDomain(): MuscleExerciseBundle {
    return MuscleExerciseBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.daoToDomain()
    )
}

internal fun List<MuscleExerciseBundleDto>.dtoToDao(): List<MuscleExerciseBundleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun MuscleExerciseBundleDto.dtoToDao(): MuscleExerciseBundleDao? {
    return MuscleExerciseBundleDao(
        id = id ?: return null,
        percentage = percentage ?: return null,
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
        muscle = muscle?.domainToDto(),
        percentage = percentage
    )
}