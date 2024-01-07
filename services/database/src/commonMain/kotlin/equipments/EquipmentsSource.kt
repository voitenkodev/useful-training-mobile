package equipments

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database
import equipments.mapping.mapToDao
import equipments.models.EquipmentDao
import equipments.models.EquipmentGroupDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

public class EquipmentsSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val equipmentApi by lazy { database.equipmentQueries }

    public fun getEquipmentGroups(): Flow<List<EquipmentGroupDao>> {
        return equipmentApi
            .getEquipmentGroups()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getEquipmentsByIds(ids: List<String>): Flow<List<EquipmentDao>> {
        return equipmentApi
            .getEquipmentById(ids)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { it.map { item -> item.mapToDao() } }
    }

    public fun setEquipmentGroupsWithEquipments(groups: List<EquipmentGroupDao>) {
        equipmentApi.transaction {
            groups.forEach { group ->
                equipmentApi.setEquipmentGroup(
                    id = group.id,
                    name = group.name,
                    createdAt = group.createdAt,
                    updatedAt = group.updatedAt,
                    type = group.type
                )

                group.equipments.forEach { item ->
                    equipmentApi.setEquipment(
                        id = item.id,
                        name = item.name,
                        createdAt = item.createdAt,
                        updatedAt = item.updatedAt,
                        equipmentGroupId = item.equipmentGroupId,
                        type = item.type,
                        status = item.status,
                        imageUrl = item.imageUrl
                    )
                }
            }
        }
    }

    public fun setEquipment(equipment: EquipmentDao) {
        equipmentApi.setEquipment(
            id = equipment.id,
            name = equipment.name,
            createdAt = equipment.createdAt,
            updatedAt = equipment.updatedAt,
            equipmentGroupId = equipment.equipmentGroupId,
            type = equipment.type,
            status = equipment.status,
            imageUrl = equipment.imageUrl
        )
    }

    public fun clearTables() {
        equipmentApi.deleteTableEquipment()
        equipmentApi.deleteTableEquipmentGroup()
    }
}