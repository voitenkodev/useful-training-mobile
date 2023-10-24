package traininig_exercise_iteration.mapping

import data.Iteration
import traininig_exercise_iteration.models.IterationDao

internal fun Iteration.toDao(): IterationDao {
    return IterationDao(
        id = id,
        weight = weight,
        repeat = repeat?.toInt()
    )
}