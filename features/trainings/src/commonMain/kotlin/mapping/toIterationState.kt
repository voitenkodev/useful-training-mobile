package mapping

import dto.backend.IterationDTO
import toDoubleOrIntString
import training.Iteration

internal fun List<IterationDTO>.toIterationStateList() = this.map { it.toIterationState() }

internal fun IterationDTO.toIterationState() = Iteration(
    weight = weight?.toDoubleOrIntString() ?: "",
    repeat = repeat?.toString() ?: ""
)
