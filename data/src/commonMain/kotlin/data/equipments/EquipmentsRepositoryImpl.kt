package data.equipments

import EquipmentsRepository
import data.equipments.mapping.daoToDomain
import data.equipments.mapping.dtoToDao
import equipments.EquipmentsSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.EquipmentGroup
import network.NetworkSource

internal class EquipmentsRepositoryImpl(
    private val remote: NetworkSource,
    private val local: EquipmentsSource
) : EquipmentsRepository {

    override fun observeEquipments(): Flow<List<EquipmentGroup>> {
        return local
            .getEquipmentGroups()
            .map { it.daoToDomain() }
    }

    override fun syncUserEquipments(): Flow<Unit> {
        return flow {
            val result = remote.getUserEquipments()
            local.setEquipmentGroupsWithEquipments(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun syncPublicEquipments(): Flow<Unit> {
        return flow {
            val result = remote.getPublicEquipments()
            local.setEquipmentGroupsWithEquipments(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun clearCache() {
        local.clearTables()
    }
}