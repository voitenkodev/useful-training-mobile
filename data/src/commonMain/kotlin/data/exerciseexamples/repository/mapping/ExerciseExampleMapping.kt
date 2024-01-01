package data.exerciseexamples.repository.mapping

import exercise_example_muscle.models.ExerciseExampleDao
import models.ExerciseExample
import models.ExerciseExampleDto

internal fun List<ExerciseExampleDao>.daoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.daoToDomain() }
}

internal fun ExerciseExampleDao.daoToDomain(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        description = description,
        muscleExerciseBundles = muscleExerciseBundles.daoToDomain(),
        imageUrl = imageUrl
    )
}

internal fun List<ExerciseExampleDto>.dtoToDao(): List<ExerciseExampleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun ExerciseExampleDto.dtoToDao(): ExerciseExampleDao? {
    return ExerciseExampleDao(
        id = id ?: return null,
        name = name ?: return null,
        description = description,
        muscleExerciseBundles = muscleExerciseBundles.dtoToDao(),
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        imageUrl = imageUrl
    )
}

internal fun ExerciseExample.domainToDto(): ExerciseExampleDto {
    return ExerciseExampleDto(
        id = id,
        name = name,
        description = description,
        muscleExerciseBundles = muscleExerciseBundles.domainToDto()
    )
}

internal fun List<ExerciseExampleDto>.dtoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun ExerciseExampleDto.dtoToDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null,
        description = description ?: return null,
        muscleExerciseBundles = muscleExerciseBundles.dtoToDomain(),
        imageUrl = imageUrl
    )
}