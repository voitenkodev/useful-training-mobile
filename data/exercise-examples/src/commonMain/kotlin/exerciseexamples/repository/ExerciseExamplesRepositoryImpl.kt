package exerciseexamples.repository

import ExerciseExamplesRepository
import NetworkSource
import exercise_example_muscle.ExerciseExamplesSource
import exerciseexamples.repository.mapping.domainToDto
import exerciseexamples.repository.mapping.dtoToDao
import exerciseexamples.repository.mapping.dtoToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import models.ExerciseExample
import models.Muscle

internal class ExerciseExamplesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

    override fun observeExerciseExamples(): Flow<List<ExerciseExample>> {
        return flow { emit(remote.getExerciseExamples().dtoToDomain()) }
    }

    override fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample?> {
        return flow {
            val remote = remote
                .getExerciseExample(exerciseExampleId)
                .dtoToDomain()
            emit(remote)
        }
    }

    override fun observeMuscles(): Flow<List<Muscle>> {
        return flow {
            val remote = remote
                .getMuscles()
                .dtoToDomain()
            emit(remote)
        }
    }

    override fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit> {
        return flow {
            remote.setExerciseExample(exerciseExample.domainToDto())
            emit(Unit)
        }
    }

    override fun syncExerciseExamples(): Flow<Unit> {
        return flow {
            val result = remote.getExerciseExamples()
            local.setExerciseExamples(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun syncMuscles(): Flow<Unit> {
        return flow {
            val result = remote.getMuscles()
            local.setMuscles(result.dtoToDao())
            emit(Unit)
        }
    }
}