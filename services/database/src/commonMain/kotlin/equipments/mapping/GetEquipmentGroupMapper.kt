package equipments.mapping

import data.GetEquipmentGroups
import equipments.models.EquipmentDao
import equipments.models.EquipmentGroupDao

internal fun List<GetEquipmentGroups>.mapToDao(): List<EquipmentGroupDao> {
    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull mapEquipmentGroups@{ mt ->

        val root = mt.value.firstOrNull() ?: return@mapEquipmentGroups null

        val equipments = mt.value.groupBy { it.equipmentId }.mapNotNull mapequipments@{ m ->

            val groups = m.value.firstOrNull() ?: return@mapequipments null

            EquipmentDao(
                createdAt = groups.equipmentCreatedAt ?: return@mapequipments null,
                updatedAt = groups.equipmentUpdatedAt ?: return@mapequipments null,
                equipmentGroupId = groups.id,
                id = groups.equipmentId ?: return@mapequipments null,
                name = groups.equipmentName ?: return@mapequipments null,
                type = groups.equipmentType ?: return@mapequipments null,
                status = groups.equipmentStatus,
            )
        }

        EquipmentGroupDao(
            createdAt = root.createdAt,
            updatedAt = root.updatedAt,
            name = root.name,
            type = root.type,
            id = root.id,
            equipments = equipments
        )
    }
}