package repository

import dto.backend.ExerciseDateDTO
import dto.backend.TrainingDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import source.database.DataBaseSource
import source.network.NetworkSource

class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    private enum class SOURCE { LOCAL, REMOTE }

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> {

        val remoteRequest = flow { emit(remote.getTrainings()) }
            .onEach { local.setTrainings(it) }
            .map { it to SOURCE.REMOTE }

        val localRequest = local.getTrainings()
            .map { it to SOURCE.LOCAL }

        return merge(localRequest, remoteRequest)
            .filterNot { it.second == SOURCE.REMOTE }
            .map { it.first }
    }

    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> {

        val remoteRequest = flow { emit(remote.getTraining(trainingId)) }
            .onEach { local.setTraining(it) }
            .map { it to SOURCE.REMOTE }

        val localRequest = local.getTraining(trainingId)
            .map { it to SOURCE.LOCAL }

        return merge(localRequest, remoteRequest)
            .filterNot { it.second == SOURCE.REMOTE }
            .map { it.first }
    }

    override suspend fun setTraining(training: TrainingDTO): Flow<String> =
        flow { emit(remote.setTraining(body = training)) }

    override suspend fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
            remote.deleteTraining(trainingId)
            local.deleteTraining(trainingId)
            emit(Unit)
        }

    override suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> =
        flow { emit(remote.getExercises(query)) }

    override suspend fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override suspend fun getExerciseNameOptions() = local
        .getExerciseNames()

    override suspend fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}