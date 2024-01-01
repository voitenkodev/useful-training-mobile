package data.user.mapping

import models.UserWeights
import models.UserWeightsDto
import user_weight.models.UserWeightsDao

internal fun List<UserWeightsDao>.daoToDomain(): List<UserWeights> {
    return this.map { item ->
        item.daoToDomain()
    }
}

internal fun UserWeightsDao.daoToDomain(): UserWeights {
    return UserWeights(
        id = id,
        weight = weight,
        createdAt = createdAt
    )
}

internal fun List<UserWeightsDto>.dtoToDao(): List<UserWeightsDao> {
    return this.mapNotNull { item ->
        item.dtoToDao()
    }
}

internal fun UserWeightsDto.dtoToDao(): UserWeightsDao? {
    return UserWeightsDao(
        id = id ?: return null,
        weight = weight ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null
    )
}