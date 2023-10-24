package repository.mapping

import models.ExerciseExample
import exercise_example_muscle.models.ExerciseExampleDao


internal fun List<ExerciseExampleDao>.toDomain(): List<ExerciseExample> {
    return mapNotNull { it.toDomain() }
}

internal fun ExerciseExampleDao.toDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null
    )
}