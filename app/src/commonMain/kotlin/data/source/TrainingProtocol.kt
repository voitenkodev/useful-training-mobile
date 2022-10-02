package data.source

import data.dto.ShortTraining
import data.dto.Training
import kotlinx.coroutines.flow.Flow

interface TrainingProtocol {

    suspend fun setTraining(
        userId: String?,
        trainingId: String?,
        training: Training
    ): Flow<Unit>

    suspend fun setShortTraining(
        userId: String?,
        trainingId: String?,
        training: ShortTraining
    ): Flow<Unit>

    suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTraining>>

    suspend fun removeTraining(
        userId: String?,
        trainingId: String,
    ): Flow<Unit>

    suspend fun removeShortTraining(
        userId: String?,
        trainingId: String,
    ): Flow<Unit>

    suspend fun getTrainings(
        userId: String?,
    ): Flow<List<Training>>

}