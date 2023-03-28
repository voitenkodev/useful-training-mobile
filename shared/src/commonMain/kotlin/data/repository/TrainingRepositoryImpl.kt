package data.repository

import data.dto.ExerciseDateDTO
import data.dto.TrainingDTO
import data.source.network.TrainingProtocol
import kotlinx.coroutines.flow.Flow

internal class TrainingRepositoryImpl(private val trainingSource: TrainingProtocol) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> = trainingSource
        .getTrainings()

    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = trainingSource
        .getTraining(trainingId)

    override suspend fun getExercises(name: String): Flow<List<ExerciseDateDTO>> = trainingSource
        .getExercises(name)

    override suspend fun setTraining(training: TrainingDTO): Flow<String> = trainingSource
        .setTraining(training = training)

    override suspend fun removeTraining(trainingId: String): Flow<Unit> = trainingSource
        .deleteTraining(trainingId = trainingId)
}