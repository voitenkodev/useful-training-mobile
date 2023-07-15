package data.repository

import data.dto.ExerciseDateDTO
import data.dto.TrainingDTO
import data.source.database.LocalDataSource
import data.source.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow

internal class TrainingRepositoryImpl(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> = remote
        .getTrainings()

    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = remote
        .getTraining(trainingId)

    override suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> = remote
        .getExercises(query)

    override suspend fun setTraining(training: TrainingDTO): Flow<String> = remote
        .setTraining(training = training)

    override suspend fun removeTraining(trainingId: String): Flow<Unit> = remote
        .deleteTraining(trainingId = trainingId)

    override suspend fun setExerciseNameOptions(names: List<String>) =
        local
            .setExerciseNames(names)

    override suspend fun getExerciseNameOptions() = local
        .getExerciseNames()

    override suspend fun removeExerciseNameOption(names: List<String>): Flow<Unit> {
        TODO("Not yet implemented")
    }
}