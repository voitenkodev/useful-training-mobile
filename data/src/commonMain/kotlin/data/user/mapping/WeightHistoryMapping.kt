package data.user.mapping

import models.WeightHistory
import models.WeightHistoryDto
import user_weight.models.WeightHistoryDao

internal fun List<WeightHistoryDao>.daoToDomain(): List<WeightHistory> {
    return this.map { item ->
        item.daoToDomain()
    }.sortedByDescending { it.createdAt }
}

internal fun WeightHistoryDao.daoToDomain(): WeightHistory {
    return WeightHistory(
        id = id,
        weight = weight,
        createdAt = createdAt
    )
}

internal fun List<WeightHistoryDto>.dtoToDao(): List<WeightHistoryDao> {
    return this.mapNotNull { item ->
        item.dtoToDao()
    }
}

internal fun WeightHistoryDto.dtoToDao(): WeightHistoryDao? {
    return WeightHistoryDao(
        id = id ?: return null,
        weight = weight ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null
    )
}