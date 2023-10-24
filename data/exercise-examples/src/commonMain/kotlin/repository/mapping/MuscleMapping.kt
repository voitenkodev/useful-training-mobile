package repository.mapping

import models.Muscle
import exercise_example_muscle.models.MuscleDao

internal fun List<MuscleDao>.toDomain(): List<Muscle> {
    return mapNotNull { it.toDomain() }
}

internal fun MuscleDao.toDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null
    )
}