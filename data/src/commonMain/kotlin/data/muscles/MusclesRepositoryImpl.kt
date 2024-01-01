package data.muscles

import MusclesRepository
import NetworkSource
import data.muscles.mapping.daoToDomain
import data.muscles.mapping.dtoToDao
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.Muscle
import models.MuscleType

internal class MusclesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : MusclesRepository {

    override fun observeMuscleTypes(): Flow<List<MuscleType>> {
        return local
            .getMuscleTypes()
            .map { it.daoToDomain() }
    }

    override fun observeMusclesById(ids: List<String>): Flow<List<Muscle>> {
        return local
            .getMusclesByIds(ids)
            .map { it.daoToDomain() }
    }

    override fun syncMuscleTypes(): Flow<Unit> {
        return flow {
            val result = remote.getMuscles()
            local.setMuscleTypesWithMuscles(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun clearCache() {
        local.clearTables()
    }
}