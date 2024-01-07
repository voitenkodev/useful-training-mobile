package data.muscles

import MusclesRepository
import data.muscles.mapping.daoToDomain
import data.muscles.mapping.dtoToDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.Muscle
import models.MuscleType
import muscles.MusclesSource
import network.NetworkSource

internal class MusclesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: MusclesSource
) : MusclesRepository {

    override fun observeMuscles(): Flow<List<MuscleType>> {
        return local
            .getMuscleTypes()
            .map { it.daoToDomain() }
    }

    override fun syncUserMuscles(): Flow<Unit> {
        return flow {
            val result = remote.getUserMuscles()
            local.setMuscleTypesWithMuscles(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun syncPublicMuscles(): Flow<Unit> {
        return flow {
            val result = remote.getPublicMuscles()
            local.setMuscleTypesWithMuscles(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun observeMusclesById(ids: List<String>): Flow<List<Muscle>> {
        return local
            .getMusclesByIds(ids)
            .map { it.daoToDomain() }
    }

    override fun clearCache() {
        local.clearTables()
    }
}