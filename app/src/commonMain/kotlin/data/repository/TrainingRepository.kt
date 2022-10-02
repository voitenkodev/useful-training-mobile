package data.repository

import data.source.AuthProtocol
import data.source.TrainingProtocol
import data.dto.Training
import data.mapping.toShortTraining
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
}