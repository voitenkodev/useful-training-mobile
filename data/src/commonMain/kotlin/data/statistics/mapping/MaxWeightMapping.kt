package data.statistics.mapping

import models.MaxWeight
import network.models.MaxWeightDto

internal fun MaxWeightDto.dtoToDomain(): MaxWeight? {
    return MaxWeight(
        createdAt = createdAt ?: return null,
        exerciseId = exerciseId ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null,
        weight = weight ?: return null,
        id = id ?: return null
    )
}