package user.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import user.WeightHistory

public fun List<models.WeightHistory>.toState(): ImmutableList<WeightHistory> {
    return this
        .map { it.toState() }
        .toPersistentList()
}

public fun models.WeightHistory.toState(): WeightHistory {
    return WeightHistory(
        id = id,
        createdAt = createdAt,
        weight = weight
    )
}