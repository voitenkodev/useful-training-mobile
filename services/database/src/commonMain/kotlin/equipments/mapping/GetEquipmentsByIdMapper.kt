package equipments.mapping

import data.GetEquipmentById
import equipments.models.EquipmentDao

internal fun GetEquipmentById.mapToDao(): EquipmentDao {
    return EquipmentDao(
        id = id,
        name = name,
        type = type,
        equipmentGroupId = equipmentGroupId,
        createdAt = createdAt,
        updatedAt = updatedAt,
        status = status,
        imageUrl = imageUrl
    )
}