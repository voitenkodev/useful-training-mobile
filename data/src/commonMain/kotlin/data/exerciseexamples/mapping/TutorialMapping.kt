package data.exerciseexamples.mapping

import exercise_examples.models.ExerciseExampleTutorialDao
import models.InputExerciseExampleTutorial
import models.ResourceTypeEnum
import models.Tutorial
import network.models.TutorialDto

internal fun InputExerciseExampleTutorial.domainToDto(): TutorialDto {
    return TutorialDto(
        author = author,
        resourceType = resourceType.key,
        language = language,
        value = value,
        title = title
    )
}

internal fun List<ExerciseExampleTutorialDao>.daoToDomain(): List<Tutorial> {
    return mapNotNull { it.daoToDomain() }
}

internal fun ExerciseExampleTutorialDao.daoToDomain(): Tutorial {
    return Tutorial(
        id = id,
        resourceType = ResourceTypeEnum.of(resourceType),
        author = author,
        title = title,
        language = language,
        value = value
    )
}

internal fun List<TutorialDto>.dtoToDao(): List<ExerciseExampleTutorialDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun TutorialDto.dtoToDao(): ExerciseExampleTutorialDao? {
    return ExerciseExampleTutorialDao(
        id = id ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        author = author,
        resourceType = resourceType ?: return null,
        language = language ?: return null,
        title = title ?: return null,
        value = value ?: return null
    )
}

internal fun List<TutorialDto>.dtoToDomain(): List<Tutorial> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun TutorialDto.dtoToDomain(): Tutorial? {
    return Tutorial(
        id = id ?: return null,
        author = author ?: return null,
        resourceType = ResourceTypeEnum.of(resourceType),
        language = language ?: return null,
        title = title ?: return null,
        value = value ?: return null
    )
}