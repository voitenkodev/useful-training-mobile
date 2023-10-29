package exerciseexample.repository

import ExerciseExamplesRepository
import NetworkSource
import exerciseexample.repository.mapping.domainToDto
import exerciseexample.repository.mapping.dtoToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import models.ExerciseExample
import models.Muscle

internal class ExerciseExamplesRepositoryImpl(
    private val remote: NetworkSource,
) : ExerciseExamplesRepository {

    override fun getExerciseExamples(): Flow<List<ExerciseExample>> {
        return flow {
            emit(remote.getExerciseExamples().dtoToDomain())
        }
    }

    override fun getExerciseExample(exerciseExampleId: String): Flow<ExerciseExample> {
        return flow {
            emit(remote.getExerciseExample(exerciseExampleId))
        }.mapNotNull {
            it.dtoToDomain()
        }
    }

    override fun getMuscles(): Flow<List<Muscle>> {
        return flow {
            emit(remote.getMuscles().dtoToDomain())
        }
    }

    override fun setExerciseExample(exerciseExample: ExerciseExample): Flow<String?> {
        return flow {
            emit(remote.setExerciseExample(exerciseExample.domainToDto()))
        }.map { it.id }
    }
}