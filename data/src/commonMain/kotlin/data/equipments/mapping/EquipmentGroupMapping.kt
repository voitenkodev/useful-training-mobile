package data.equipments.mapping

import equipments.models.EquipmentGroupDao
import models.EquipmentGroup
import network.models.EquipmentGroupDto

internal fun List<EquipmentGroupDao>.daoToDomain(): List<EquipmentGroup> {
    return mapNotNull { it.daoToDomain() }
        .sortedBy { it.equipments.count() }
}

internal fun EquipmentGroupDao.daoToDomain(): EquipmentGroup {
    return EquipmentGroup(
        id = id,
        name = name,
        equipments = equipments.daoToDomain()
    )
}

internal fun List<EquipmentGroupDto>.dtoToDao(): List<EquipmentGroupDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun EquipmentGroupDto.dtoToDao(): EquipmentGroupDao? {
    return EquipmentGroupDao(
        id = id ?: return null,
        name = name ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        equipments = equipments?.dtoToDao() ?: emptyList(),
        type = type ?: return null
    )
}