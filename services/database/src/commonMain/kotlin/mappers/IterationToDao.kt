package mappers

import data.Iteration
import models.IterationDao

internal fun Iteration.toDao(): IterationDao {
    return IterationDao(
        id = this.id,
        weight = this.weight,
        repeat = this.repeat?.toInt()
    )
}