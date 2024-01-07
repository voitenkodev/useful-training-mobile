package equipments.mapping

import data.GetMusclesById
import equipments.models.EquipmentDao

internal fun GetMusclesById.mapToDao(): EquipmentDao {
    return EquipmentDao(
        id = id,
        name = name,
        type = type,
        equipmentGroupId = muscleGroupId,
        createdAt = createdAt,
        updatedAt = updatedAt,
        status = status
    )
}