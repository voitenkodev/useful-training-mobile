package repository

import DataBaseSource
import NetworkSource
import TrainingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
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

class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<Training>> {
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

    override suspend fun getTraining(trainingId: String): Flow<Training> {
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

    override suspend fun setTraining(training: Training): Flow<String> =
        flowOf(remote.setTraining(body = training.toDto()))

    override suspend fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
            remote.deleteTraining(trainingId)
            local.deleteTraining(trainingId)
            emit(Unit)
        }

    override suspend fun getExercises(query: String): Flow<List<ExerciseDate>> =
        flowOf(remote.getExercises(query))
            .map { it.map { it.toDomain() } }

    override suspend fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override suspend fun getExerciseNameOptions() = local
        .getExerciseNames()

    override suspend fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}