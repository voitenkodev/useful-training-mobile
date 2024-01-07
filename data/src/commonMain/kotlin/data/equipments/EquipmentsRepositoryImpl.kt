package data.equipments

import EquipmentsRepository
import equipments.EquipmentsSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import models.EquipmentGroup
import models.MuscleGroup
import network.NetworkSource

internal class EquipmentsRepositoryImpl(
    private val remote: NetworkSource,
    private val local: EquipmentsSource
) : EquipmentsRepository {
    override fun observeEquipments(): Flow<List<EquipmentGroup>> {
//        return local
//            .getEquipmentGroups()
//            .map { it.daoToDomain() }
    }

    override fun syncUserEquipments(): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override fun syncPublicEquipments(): Flow<Unit> {
        TODO("Not yet implemented")
    }

//    override fun observeEquipments(): Flow<List<MuscleGroup>> {
        return local
            .getMuscleGroups()
            .map { it.daoToDomain() }
//    }
//
//
//    override fun syncUserMuscles(): Flow<Unit> {
//        return flow {
//            val result = remote.getUserMuscles()
//            local.setMuscleGroupsWithMuscles(result.dtoToDao())
//            emit(Unit)
//        }
//    }
//
//    override fun syncPublicMuscles(): Flow<Unit> {
//        return flow {
//            val result = remote.getPublicMuscles()
//            local.setMuscleGroupsWithMuscles(result.dtoToDao())
//            emit(Unit)
//        }
//    }
//
//    override fun observeMusclesById(ids: List<String>): Flow<List<Muscle>> {
//        return local
//            .getMusclesByIds(ids)
//            .map { it.daoToDomain() }
//    }

    override fun clearCache() {
        local.clearTables()
    }
}