package data.exerciseexamples

import ExerciseExamplesRepository
import NetworkSource
import data.exerciseexamples.mapping.daoToDomain
import data.exerciseexamples.mapping.domainToDto
import data.exerciseexamples.mapping.dtoToDao
import data.exerciseexamples.mapping.dtoToDomain
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import models.ExerciseExample

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

    override fun syncExerciseExamples(): Flow<Unit> {
        return flow {
            val result = remote.getAllExerciseExamples()
            local.setExerciseExamples(result.dtoToDao())
            emit(Unit)
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

    override fun getRecommendedExerciseExamples(): Flow<List<ExerciseExample>> {
        return flow {
            val result = remote.getRecommendedExerciseExamples()
            emit(result.dtoToDomain())
        }
    }

    override fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit> {
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