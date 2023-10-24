package exerciseexample.repository.mapping

import exercise_example_muscle.models.ExerciseExampleDao
import models.ExerciseExample

internal fun List<ExerciseExampleDao>.toDomain(): List<ExerciseExample> {
    return mapNotNull { it.toDomain() }
}

internal fun ExerciseExampleDao.toDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null
    )
}

internal fun List<ExerciseExample>.toDao(): List<ExerciseExampleDao> {
    return mapNotNull { it.toDao() }
}

internal fun ExerciseExample.toDao(): ExerciseExampleDao {
    return ExerciseExampleDao(
        id = id,
        name = name
    )
}