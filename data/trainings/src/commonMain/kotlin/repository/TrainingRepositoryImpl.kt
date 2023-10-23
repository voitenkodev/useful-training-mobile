package repository

import DataBaseSource
import NetworkSource
import TrainingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import mappers.daoToDomain
import mappers.dtoToDao
import mappers.dtoToDomain
import mappers.toDomain
import mappers.toDto
import models.ExerciseDate
import models.Training

internal class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    override fun getTrainings(): Flow<List<Training>> {
        val remote = flow {
            val response = remote.getTrainings()
            local.setTrainings(response.dtoToDao())
            emit(response.dtoToDomain())
        }

        val local = local.getTrainings()
            .map { it.daoToDomain() }

        return flowOf(local, remote)
            .flattenMerge()
    }

    override fun getTraining(trainingId: String): Flow<Training> {
        val remote = flow {
            val response = remote.getTraining(trainingId)
            local.setTraining(response.dtoToDao())
            emit(response.dtoToDomain())
        }

        val local = local.getTraining(trainingId)
            .map { it.toDomain() }

        return flowOf(local, remote)
            .flattenMerge()
    }

    override fun setTraining(training: Training): Flow<String> {
        val remote = flow {
            val response = remote.setTraining(body = training.toDto())
            emit(response)
        }

        return remote
    }

    override fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
            remote.deleteTraining(trainingId)
            local.deleteTraining(trainingId)
            emit(Unit)
        }

    override fun getExercises(query: String): Flow<List<ExerciseDate>> {
        val remote = flow {
            val response = remote.getExercises(query)
            emit(response)
        }
        return remote
            .map { it.map { it.toDomain() } }
    }
}