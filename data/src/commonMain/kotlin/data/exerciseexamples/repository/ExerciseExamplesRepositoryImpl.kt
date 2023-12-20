package data.exerciseexamples.repository

import ExerciseExamplesRepository
import NetworkSource
import data.exerciseexamples.repository.mapping.daoToDomain
import data.exerciseexamples.repository.mapping.domainToDto
import data.exerciseexamples.repository.mapping.dtoToDao
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import models.ExerciseExample
import models.Muscle
import models.MuscleType

internal class ExerciseExamplesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

    override fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample> {
        return local
            .getExerciseExampleById(exerciseExampleId)
            .mapNotNull { it?.daoToDomain() }
    }

    override fun recommendedExerciseExample(): Flow<List<ExerciseExample>> {
        return flow {
            emit(emptyList())
        }
    }

    override fun observeExerciseExamples(): Flow<List<ExerciseExample>> {
        return local
            .getExerciseExamples()
            .map { it.daoToDomain() }
    }

    override fun syncExerciseExamples(): Flow<Unit> {
        return flow {
            val result = remote.getExerciseExamples()
            local.setExerciseExamples(result.dtoToDao())
            emit(Unit)
        }
    }

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

    override fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit> {
        return flow {
            remote
                .setExerciseExample(exerciseExample.domainToDto())
                .dtoToDao()
                ?.let { dao -> local.setExerciseExample(dao) }
            emit(Unit)
        }
    }

    override fun clearCache() {
        local.clearTables()
    }
}