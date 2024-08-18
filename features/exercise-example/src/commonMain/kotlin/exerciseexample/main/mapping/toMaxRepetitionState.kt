package exerciseexample.main.mapping

import DateTimeKtx
import models.MaxRepetition

internal fun MaxRepetition.toState(): exerciseexample.main.models.MaxRepetition {
    return exerciseexample.main.models.MaxRepetition(
        createdAt = DateTimeKtx.formattedDate1(createdAt) ?: "-",
        exerciseExampleId = exerciseExampleId,
        id = id,
        repetition = repetition,
        exerciseId = exerciseId
    )
}