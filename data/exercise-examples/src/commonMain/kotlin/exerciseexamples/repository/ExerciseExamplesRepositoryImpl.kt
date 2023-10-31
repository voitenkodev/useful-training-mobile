package exerciseexamples.repository

import ExerciseExamplesRepository
import NetworkSource
import exercise_example_muscle.ExerciseExamplesSource
import exerciseexamples.repository.mapping.daoToDomain
import exerciseexamples.repository.mapping.domainToDto
import exerciseexamples.repository.mapping.dtoToDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.ExerciseExample
import models.Muscle

internal class ExerciseExamplesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

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

    override fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample> {
        return local
            .getExerciseExampleById(exerciseExampleId)
            .map { it.daoToDomain() }
    }

    override fun observeMuscles(): Flow<List<Muscle>> {
        return local
            .getMuscles()
            .map { it.daoToDomain() }
    }

    override fun syncMuscles(): Flow<Unit> {
        return flow {
            val result = remote.getMuscles()
            local.setMuscles(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit> {
        return flow {
            remote.setExerciseExample(exerciseExample.domainToDto())
            emit(Unit)
        }
    }
}