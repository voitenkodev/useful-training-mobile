package userequipments.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.EquipmentStatusEnum
import userequipments.main.models.Equipment
import userequipments.main.models.StatusEnum

internal fun List<models.Equipment>.toState(): ImmutableList<Equipment> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.Equipment.toState(): Equipment? {
    return Equipment(
        name = name,
        id = id,
        loading = false,
        imageUrl = imageUrl,
        status = status.toState() ?: return null,
    )
}

private fun EquipmentStatusEnum.toState(): StatusEnum? {
    return when (this) {
        EquipmentStatusEnum.EXCLUDED -> StatusEnum.EXCLUDED
        EquipmentStatusEnum.UNKNOWN -> null
        else -> StatusEnum.INCLUDED
    }
}