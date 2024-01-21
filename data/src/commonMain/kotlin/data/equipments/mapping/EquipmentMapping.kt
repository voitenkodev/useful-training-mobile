package data.equipments.mapping

import equipments.models.EquipmentDao
import models.Equipment
import models.EquipmentEnum
import models.EquipmentStatusEnum
import network.models.EquipmentDto

internal fun List<EquipmentDao>.daoToDomain(): List<Equipment> {
    return mapNotNull { it.daoToDomain() }
        .sortedBy { it.status }
}

internal fun EquipmentDao.daoToDomain(): Equipment {
    return Equipment(
        id = id,
        name = name,
        type = EquipmentEnum.of(type),
        status = EquipmentStatusEnum.of(status)
    )
}

internal fun List<EquipmentDto>.dtoToDao(): List<EquipmentDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun EquipmentDto.dtoToDao(): EquipmentDao? {
    return EquipmentDao(
        id = id ?: return null,
        name = name ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        equipmentGroupId = equipmentGroupId ?: return null,
        type = type ?: return null,
        status = status
    )
}

internal fun EquipmentDto.dtoToDomain(): Equipment? {
    return Equipment(
        id = id ?: return null,
        name = name ?: return null,
        type = EquipmentEnum.of(type),
        status = EquipmentStatusEnum.of(status)
    )
}

internal fun Equipment.domainToDto(): EquipmentDto {
    return EquipmentDto(
        id = id
    )
}