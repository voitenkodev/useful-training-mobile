package data.repository

import data.dto.TrainingBody
import data.source.network.TrainingProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class TrainingRepositoryImpl(
    private val trainingSource: TrainingProtocol,
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingBody>> = trainingSource
        .getTrainings()

    override suspend fun getTraining(trainingId: String): Flow<TrainingBody> = trainingSource
        .getTraining(trainingId)

    override suspend fun setTraining(training: TrainingBody): Flow<String> = trainingSource
        .setTraining(training = training)

    override suspend fun removeTraining(trainingId: String): Flow<Unit> = flow { emit(Unit) }
//        .removeTraining(
//            trainingId = trainingId,
//        ).combine(
//            trainingSource.removeShortTraining(
//                userId = authSource.userDto?.uid,
//                trainingId = trainingId
//            )
//        ) { _, _ -> }
//        //.flowOn(dispatcher)
}