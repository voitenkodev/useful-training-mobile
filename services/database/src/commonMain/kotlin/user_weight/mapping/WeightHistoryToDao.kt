package user_weight.mapping

import data.WeightHistory
import user_weight.models.WeightHistoryDao

internal fun WeightHistory.toDao(): WeightHistoryDao {
    return WeightHistoryDao(
        id = id,
        weight = weight,
        updatedAt = updatedAt,
        createdAt = createdAt
    )
}