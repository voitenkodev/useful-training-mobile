package repository

import DataBaseSource
import NetworkSource
import TrainingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import mappers.toDao
import mappers.toDomain
import mappers.daoToDomain
import mappers.dtoToDomain
import mappers.toDto
import models.ExerciseDate
import models.Training

class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<Training>> {

        val remote = flowOf(remote.getTrainings())
            .onEach { local.setTrainings(it.toDao()) }
            .map { it.dtoToDomain() }

        val local = local.getTrainings()
            .map { it.daoToDomain() }

        return merge(local, remote)
            .distinctUntilChanged()
    }

    override suspend fun getTraining(trainingId: String): Flow<Training> {

        val remote = flowOf(remote.getTraining(trainingId))
            .onEach { local.setTraining(it.toDao()) }
            .map { it.toDomain() }

        val local = local.getTraining(trainingId)
            .map { it.toDomain() }

        return merge(local, remote)
            .distinctUntilChanged()
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