package user.mapping

import data.WeightHistory
import user.models.WeightHistoryDao

internal fun WeightHistory.toDao(): WeightHistoryDao {
    return WeightHistoryDao(
        id = id,
        weight = weight,
        updatedAt = updatedAt,
        createdAt = createdAt
    )
}