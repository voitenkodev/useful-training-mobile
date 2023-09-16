package repository

import dto.backend.ExerciseDateDTO
import dto.backend.TrainingDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import source.database.DataBaseSource
import source.network.NetworkSource

class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> {

        val remoteRequest = flow {
            emit(remote.getTrainings())
        }.onEach {
            local.setTrainings(it)
        }

        val localRequest = local
            .getTrainings()

        return merge(localRequest, remoteRequest)
    }

    // TODO OVERRIDE
    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = local
        .getTraining(trainingId)
        .onStart {
            val training = remote.getTraining(trainingId)
            local.setTraining(training)
        }

    // TODO ADD LOCAL CALL
    override suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> =
        flowOf(remote.getExercises(query))

    override suspend fun setTraining(training: TrainingDTO): Flow<String> =
        flowOf(remote.setTraining(training = training))

    override suspend fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
            remote.deleteTraining(trainingId)
            local.deleteTraining(trainingId)
            emit(Unit)
        }

    override suspend fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override suspend fun getExerciseNameOptions() = local
        .getExerciseNames()

    override suspend fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}