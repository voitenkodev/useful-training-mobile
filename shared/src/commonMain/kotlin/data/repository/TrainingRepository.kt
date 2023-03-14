package data.repository

import data.dto.TrainingBody
import kotlinx.coroutines.flow.Flow

internal interface TrainingRepository {
    suspend fun getTrainings(): Flow<List<TrainingBody>>

    suspend fun setTraining(training: TrainingBody): Flow<TrainingBody>

//    suspend fun removeTraining(trainingId: String): Flow<Unit>
}