package weighthistory.main.mapping

import DateTimeKtx
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import weighthistory.main.models.WeightHistory

internal fun List<models.WeightHistory>.toState(): ImmutableList<WeightHistory> {
    return this
        .map { it.toState() }
        .toPersistentList()
}

internal fun models.WeightHistory.toState(): WeightHistory {
    return WeightHistory(
        id = id,
        createdAt = DateTimeKtx.formattedLongDate(createdAt) ?: "-",
        weight = weight
    )
}