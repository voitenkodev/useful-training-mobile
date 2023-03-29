package data.mapping

import data.dto.IterationDTO
import presentation.training.Iteration

internal fun List<IterationDTO?>.toIterationStateList() = this.sortedBy { it?.id }.mapNotNull { it?.toIterationState() }

internal fun IterationDTO.toIterationState() = Iteration(
    weight = weight?.toDoubleOrIntString() ?: "",
    repeat = repeat?.toString() ?: ""
)
