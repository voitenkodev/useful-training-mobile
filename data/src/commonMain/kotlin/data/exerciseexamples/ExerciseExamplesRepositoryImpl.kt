package data.exerciseexamples

import ExerciseExamplesRepository
import data.exerciseexamples.mapping.daoToDomain
import data.exerciseexamples.mapping.domainToDto
import data.exerciseexamples.mapping.dtoToDao
import data.exerciseexamples.mapping.dtoToDomain
import exercise_examples.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import models.ExerciseExample
import models.InputExerciseExample
import network.NetworkSource

internal class ExerciseExamplesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

    override fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample> {
        return local
            .getExerciseExampleById(exerciseExampleId)
            .mapNotNull { it?.daoToDomain() }
    }

    override fun observeExerciseExamples(): Flow<List<ExerciseExample>> {
        return local
            .getExerciseExamples()
            .map { it.daoToDomain() }
    }

    override fun getExerciseExamples(
        page: Int,
        size: Int,
        query: String?,
        weightType: String?,
        forceType: String?,
        experience: String?,
        category: String?,
        muscleIds: List<String>,
        equipmentIds: List<String>
    ): Flow<List<ExerciseExample>> {
        return flow {
            val result = remote.getExerciseExamples(page, size, query, weightType, forceType, experience, category, muscleIds, equipmentIds)
            local.setExerciseExamples(result.dtoToDao())
            emit(result.dtoToDomain())
        }
    }

    override fun syncExerciseExampleById(exerciseExampleId: String): Flow<Unit> {
        return flow {
            val result = remote
                .getExerciseExample(exerciseExampleId)
                .dtoToDao()
            if (result != null) local.setExerciseExample(result)
            emit(Unit)
        }
    }

    override fun getRecommendedExerciseExamples(
        page: Int,
        size: Int,
        targetMuscleId: String?,
        exerciseCount: Int?,
        exerciseExampleIds: List<String>
    ): Flow<List<ExerciseExample>> {
        return flow {
            val result = remote.getRecommendedExerciseExamples(page, size, exerciseCount, targetMuscleId, exerciseExampleIds)
            emit(result.dtoToDomain())
        }
    }

    override fun setExerciseExample(exerciseExample: InputExerciseExample): Flow<Unit> {
        return flow {
            val result = remote
                .setExerciseExample(exerciseExample.domainToDto())
                .dtoToDao()
            if (result != null) local.setExerciseExample(result)
            emit(Unit)
        }
    }

    override fun clearCache() {
        local.clearTables()
    }
}