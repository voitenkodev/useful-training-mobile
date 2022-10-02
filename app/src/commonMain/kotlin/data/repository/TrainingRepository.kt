package data.repository

import com.benasher44.uuid.uuid4
import data.dto.ShortTraining
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

    suspend fun getShortTrainings(): Flow<List<ShortTraining>> = trainingSource
        .getShortTrainings(
            userId = authSource.user?.uid,
        )

    suspend fun getTrainings(): Flow<List<Training>> = trainingSource
        .getTrainings(
            userId = authSource.user?.uid
        )

    suspend fun setTraining(training: Training): Flow<Unit> {
        val id = training.id ?: uuid4().toString()

        return trainingSource
            .setTraining(
                userId = authSource.user?.uid,
                trainingId = id,
                training = training
            ).combine(
                trainingSource.setShortTraining(
                    authSource.user?.uid,
                    trainingId = id,
                    training = training.toShortTraining()
                )
            ) { _, _ -> }
    }

    suspend fun removeTraining(trainingId: String): Flow<Unit> = trainingSource
        .removeTraining(
            userId = authSource.user?.uid,
            trainingId = trainingId,
        ).combine(
            trainingSource.removeShortTraining(
                userId = authSource.user?.uid,
                trainingId = trainingId
            )
        ) { _, _ -> }
}