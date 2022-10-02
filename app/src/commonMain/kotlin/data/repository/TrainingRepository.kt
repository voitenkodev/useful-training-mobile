package data.repository

import data.dto.Training
import data.mapping.toShortTraining
import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class TrainingRepository(
    private val authSource: AuthProtocol,
    private val trainingSource: TrainingProtocol
) {

    suspend fun setTraining(training: Training): Flow<Unit> = trainingSource
        .setTraining(
            userId = authSource.user?.uid,
            trainingId = training.id,
            training = training
        ).combine(
            trainingSource.setShortTraining(
                authSource.user?.uid,
                trainingId = training.id,
                training = training.toShortTraining()
            )
        ) { _, _ -> }

    suspend fun removeTraining(trainingId: String): Flow<Unit> = trainingSource
        .removeTraining(
            userId = authSource.user?.uid,
            trainingId = trainingId,
        ).combine(
            trainingSource.removeShortTraining(
                authSource.user?.uid,
                trainingId = trainingId
            )
        ) { _, _ -> }
}