package data.source

import data.dto.TrainingBody
import kotlinx.coroutines.flow.Flow

internal interface TrainingProtocol {

    suspend fun setTraining(userId: String?, training: TrainingBody): Flow<String>

    suspend fun getTrainings(userId: String?): Flow<List<TrainingBody>>

    suspend fun getTraining(userId: String?, trainingId: String): Flow<TrainingBody>

    suspend fun deleteTraining(userId: String?, trainingId: String): Flow<Unit>
}