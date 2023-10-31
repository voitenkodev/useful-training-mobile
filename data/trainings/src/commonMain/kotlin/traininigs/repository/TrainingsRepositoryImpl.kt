package traininigs.repository

import NetworkSource
import TrainingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.Training
import traininig_exercise_iteration.TrainingsSource
import traininigs.mapping.daoToDomain
import traininigs.mapping.domainToDto
import traininigs.mapping.dtoToDao

internal class TrainingsRepositoryImpl(
    private val remote: NetworkSource,
    private val local: TrainingsSource
) : TrainingsRepository {

    override fun observeTrainings(startDate: String, endDate: String): Flow<List<Training>> {
        return local
            .getTrainings()
            .map { it.daoToDomain() }
    }

    override fun syncTrainings(startDate: String, endDate: String): Flow<Unit> {
        return flow {
            val result = remote.getTrainings(startDate, endDate)
            local.setTrainings(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun observeTraining(trainingId: String): Flow<Training?> {
        return local
            .getTraining(trainingId)
            .map { it.daoToDomain() }
    }

    override fun setTraining(training: Training): Flow<String?> {
        return flow {
            val response = remote.setTraining(body = training.domainToDto())
            emit(response.id)
        }
    }

    override fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
//            remote.deleteTraining(trainingId)
//            local.deleteTraining(trainingId)
//            emit(Unit)
        }
}