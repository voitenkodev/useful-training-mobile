package data.exerciseexamples.mapping

import data.muscles.mapping.daoToDomain
import data.muscles.mapping.domainToDto
import data.muscles.mapping.dtoToDao
import data.muscles.mapping.dtoToDomain
import exercise_example_muscle.models.ExerciseExampleBundleDao
import models.ExerciseExampleBundle
import network.models.ExerciseExampleBundleDto

internal fun List<ExerciseExampleBundleDao>.daoToDomain(): List<ExerciseExampleBundle> {
    return map { it.daoToDomain() }
}

internal fun ExerciseExampleBundleDao.daoToDomain(): ExerciseExampleBundle {
    return ExerciseExampleBundle(
        id = id,
        percentage = percentage,
        muscle = muscle.daoToDomain()
    )
}

internal fun List<ExerciseExampleBundleDto>.dtoToDao(): List<ExerciseExampleBundleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun ExerciseExampleBundleDto.dtoToDao(): ExerciseExampleBundleDao? {
    return ExerciseExampleBundleDao(
        id = id ?: return null,
        percentage = percentage ?: return null,
        muscle = muscle?.dtoToDao() ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        muscleId = muscleId ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null
    )
}

internal fun List<ExerciseExampleBundleDto>.dtoToDomain(): List<ExerciseExampleBundle> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun ExerciseExampleBundleDto.dtoToDomain(): ExerciseExampleBundle? {
    return ExerciseExampleBundle(
        id = id ?: return null,
        percentage = percentage ?: return null,
        muscle = muscle?.dtoToDomain() ?: return null
    )
}

internal fun List<ExerciseExampleBundle>.domainToDto(): List<ExerciseExampleBundleDto> {
    return mapNotNull { it.domainToDto() }
}

internal fun ExerciseExampleBundle.domainToDto(): ExerciseExampleBundleDto {
    return ExerciseExampleBundleDto(
        id = id,
        muscle = muscle.domainToDto(),
        percentage = percentage
    )
}