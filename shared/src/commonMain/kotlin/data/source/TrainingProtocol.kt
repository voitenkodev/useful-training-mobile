package data.source

import data.dto.TrainingBody
import kotlinx.coroutines.flow.Flow

internal interface TrainingProtocol {

    suspend fun setTraining(userId: String?, training: TrainingBody): Flow<Unit>

    suspend fun getTrainings(userId: String?): Flow<List<TrainingBody>>
}