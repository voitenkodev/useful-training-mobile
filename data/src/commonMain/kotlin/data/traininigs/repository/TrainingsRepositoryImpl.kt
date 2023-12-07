package data.traininigs.repository

import NetworkSource
import TrainingsRepository
import data.traininigs.mapping.daoToDomain
import data.traininigs.mapping.domainToDto
import data.traininigs.mapping.dtoToDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.Training
import traininig_exercise_iteration.TrainingsSource

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
            .map { it?.daoToDomain() }
    }

    override fun setTraining(training: Training): Flow<String?> {
        return flow {
            val id = remote
                .setTraining(body = training.domainToDto())
                .dtoToDao()
                ?.let { dao -> local.setTraining(dao) }
            emit(id)
        }
    }

    override fun clearCache() {
        local.clearTables()
    }

    override fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
//            remote.deleteTraining(trainingId)
//            local.deleteTraining(trainingId)
//            emit(Unit)
        }
}