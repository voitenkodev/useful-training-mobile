package exerciseexample.main.mapping

import DateTimeKtx
import models.MaxWeight

internal fun MaxWeight.toState(): exerciseexample.main.models.MaxWeight {
    return exerciseexample.main.models.MaxWeight(
        createdAt = DateTimeKtx.formattedDate1(createdAt) ?: "-",
        exerciseExampleId = exerciseExampleId,
        id = id,
        weight = weight,
        exerciseId = exerciseId
    )
}