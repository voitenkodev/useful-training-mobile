package exerciseexample.repository.mapping

import exercise_example_muscle.models.MuscleDao
import models.Muscle

internal fun List<MuscleDao>.toDomain(): List<Muscle> {
    return mapNotNull { it.toDomain() }
}

internal fun MuscleDao.toDomain(): Muscle? {
    return Muscle(
        id = id ?: return null,
        name = name ?: return null
    )
}

internal fun List<Muscle>.toDao(): List<MuscleDao> {
    return mapNotNull { it.toDao() }
}

internal fun Muscle.toDao(): MuscleDao {
    return MuscleDao(
        id = id,
        name = name
    )
}