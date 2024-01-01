package user_weight.mapping

import data.UserWeights
import user_weight.models.UserWeightsDao

internal fun UserWeights.toDao(): UserWeightsDao {
    return UserWeightsDao(
        id = id,
        weight = weight,
        updatedAt = updatedAt,
        createdAt = createdAt
    )
}