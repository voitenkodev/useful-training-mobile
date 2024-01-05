package data.statistics.mapping

import models.MaxRepetition
import network.models.MaxRepetitionDto

internal fun MaxRepetitionDto.dtoToDomain(): MaxRepetition? {
    return MaxRepetition(
        createdAt = createdAt ?: return null,
        exerciseId = exerciseId ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null,
        repetition = repetition ?: return null,
        id = id ?: return null
    )
}