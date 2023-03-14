package data.repository

import data.dto.TrainingBody
import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlinx.coroutines.flow.Flow

internal class TrainingRepositoryImpl(
    private val authSource: AuthProtocol,
    private val trainingSource: TrainingProtocol,
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingBody>> = trainingSource
        .getTrainings(userId = "e86eedac-5bfc-4f25-9dc9-f83148fdb7f0")

    override suspend fun setTraining(training: TrainingBody): Flow<TrainingBody> = trainingSource
        .setTraining(
            userId = "e86eedac-5bfc-4f25-9dc9-f83148fdb7f0",
            training = training
        )

//    override suspend fun removeTraining(trainingId: String): Flow<Unit> = trainingSource
//        .removeTraining(
//            userId = authSource.userDto?.uid,
//            trainingId = trainingId,
//        ).combine(
//            trainingSource.removeShortTraining(
//                userId = authSource.userDto?.uid,
//                trainingId = trainingId
//            )
//        ) { _, _ -> }
//        //.flowOn(dispatcher)
}