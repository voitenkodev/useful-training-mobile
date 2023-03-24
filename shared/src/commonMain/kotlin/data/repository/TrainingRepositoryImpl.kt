package data.repository

import data.dto.TrainingBody
import data.source.network.TrainingProtocol
import kotlinx.coroutines.flow.Flow

internal class TrainingRepositoryImpl(
    private val trainingSource: TrainingProtocol,
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingBody>> = trainingSource
        .getTrainings()

    override suspend fun getTraining(trainingId: String): Flow<TrainingBody> = trainingSource
        .getTraining(trainingId)

    override suspend fun setTraining(training: TrainingBody): Flow<String> = trainingSource
        .setTraining(training = training)

    override suspend fun removeTraining(trainingId: String): Flow<Unit> = trainingSource
        .deleteTraining(trainingId = trainingId)
}