package exerciseexample.repository.mapping

import exercise_example_muscle.models.ExerciseExampleDao
import models.ExerciseExample
import models.ExerciseExampleDto

// _______ NETWORK _______

internal fun List<ExerciseExampleDto>.dtoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun ExerciseExampleDto.dtoToDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null,
        muscleExerciseBundles = muscleExerciseBundles.dtoToDomain()
    )
}

// _______ DATABASE _______

internal fun List<ExerciseExampleDao>.daoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.daoToDomain() }
}

internal fun ExerciseExampleDao.daoToDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null
    )
}

// _______ DOMAIN _______

internal fun List<ExerciseExample>.domainToDao(): List<ExerciseExampleDao> {
    return mapNotNull { it.domainToDao() }
}

internal fun ExerciseExample.domainToDao(): ExerciseExampleDao {
    return ExerciseExampleDao(
        id = id,
        name = name
    )
}

internal fun ExerciseExample.domainToDto(): ExerciseExampleDto {
    return ExerciseExampleDto(
        id = id,
        name = name,
        muscleExerciseBundles = muscleExerciseBundles.domainToDto()
    )
}