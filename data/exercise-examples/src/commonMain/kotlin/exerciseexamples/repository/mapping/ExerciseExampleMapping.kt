package exerciseexamples.repository.mapping

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
        muscleExerciseBundles = muscleExerciseBundles.daoToDomain()
    )
}

internal fun List<ExerciseExampleDto>.dtoToDao(): List<ExerciseExampleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun ExerciseExampleDto.dtoToDao(): ExerciseExampleDao? {
    return ExerciseExampleDao(
        id = id ?: return null,
        name = name ?: return null,
        muscleExerciseBundles = muscleExerciseBundles.dtoToDao(),
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null
    )
}

internal fun ExerciseExample.domainToDto(): ExerciseExampleDto {
    return ExerciseExampleDto(
        id = id,
        name = name,
        muscleExerciseBundles = muscleExerciseBundles.domainToDto()
    )
}