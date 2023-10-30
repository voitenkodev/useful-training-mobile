package traininigs.repository

import NetworkSource
import TrainingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import models.Training
import traininig_exercise_iteration.TrainingsSource
import traininigs.mapping.daoToDomain
import traininigs.mapping.dtoToDao
import traininigs.mapping.dtoToDomain
import traininigs.mapping.toDomain
import traininigs.mapping.toDto

internal class TrainingsRepositoryImpl(
    private val remote: NetworkSource,
    private val local: TrainingsSource
) : TrainingsRepository {

    override fun getTrainings(startDate: String, endDate: String): Flow<List<Training>> {
        val remote = flow {
            val response = remote.getTrainings(
                startDate = startDate,
                endDate = endDate
            )
            local.setTrainings(response.dtoToDao())
            emit(response.dtoToDomain())
        }

        val local = local.getTrainings()
            .map { it.daoToDomain() }

        return flowOf(local, remote)
            .flattenMerge()
    }

    override fun getTraining(trainingId: String): Flow<Training?> {
        val remote = flow {
            val response = remote.getTraining(trainingId)
            local.setTraining(response.dtoToDao())
            emit(response.dtoToDomain())
        }

        val local = local
            .getTraining(trainingId)
            .map { it.toDomain() }

        return flowOf(local, remote)
            .flattenMerge()
    }

    override fun setTraining(training: Training): Flow<String?> {
        val remote = flow {
            val response = remote.setTraining(body = training.toDto())
            emit(response)
        }

        return remote.map { it.id }
    }

    override fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
//            remote.deleteTraining(trainingId)
//            local.deleteTraining(trainingId)
//            emit(Unit)
        }
}