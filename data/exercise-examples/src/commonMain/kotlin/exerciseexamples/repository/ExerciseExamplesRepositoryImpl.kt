package exerciseexamples.repository

import ExerciseExamplesRepository
import NetworkSource
import exercise_example_muscle.ExerciseExamplesSource
import exerciseexamples.repository.mapping.domainToDto
import exerciseexamples.repository.mapping.dtoToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import models.ExerciseExample
import models.Muscle

internal class ExerciseExamplesRepositoryImpl(
    private val remote: NetworkSource,
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

    override fun getExerciseExamples(): Flow<List<ExerciseExample>> {
        return flow { emit(remote.getExerciseExamples().dtoToDomain()) }
    }

    override fun getExerciseExample(exerciseExampleId: String): Flow<ExerciseExample?> {
        return flow {
            val remote = remote
                .getExerciseExample(exerciseExampleId)
                .dtoToDomain()
            emit(remote)
        }
    }

    override fun getMuscles(): Flow<List<Muscle>> {
        return flow {
            val remote = remote
                .getMuscles()
                .dtoToDomain()
            emit(remote)
        }
    }

    override fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit> {
        return flow {
            remote
                .setExerciseExample(exerciseExample.domainToDto())
            emit(Unit)
        }
    }
}