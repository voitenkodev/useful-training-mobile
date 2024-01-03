package data.muscles

import MusclesRepository
import data.muscles.mapping.daoToDomain
import data.muscles.mapping.dtoToDao
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.Muscle
import models.MuscleType
import network.NetworkSource

internal class MusclesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : MusclesRepository {

    override fun observeMuscleTypes(): Flow<List<MuscleType>> {
        return local
            .getMuscleTypes()
            .map { it.daoToDomain() }
    }

    override fun syncUserMuscleTypes(): Flow<Unit> {
        return flow {
            val result = remote.getUserMuscles()
            local.setMuscleTypesWithMuscles(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun syncUserMuscleById(id: String): Flow<Unit> {
        return flow {
            val result = remote
                .getUserMuscleById(id)
                .dtoToDao()
            if (result != null) local.setMuscle(result)
            emit(Unit)
        }
    }

    override fun syncPublicMuscleTypes(): Flow<Unit> {
        return flow {
            val result = remote.getUserMuscles()
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