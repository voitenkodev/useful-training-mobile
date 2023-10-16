package mapping

import toDoubleOrIntString
import training.Iteration

internal fun List<models.Iteration>.toIterationStateList() = this.map { it.toIterationState() }

internal fun models.Iteration.toIterationState() = Iteration(
    weight = weight?.toDoubleOrIntString() ?: "",
    repeat = repeat?.toString() ?: ""
)
