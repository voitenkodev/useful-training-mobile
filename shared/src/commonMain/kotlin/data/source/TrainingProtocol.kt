package data.source

import data.dto.ShortTrainingDto
import data.dto.TrainingDto
import kotlinx.coroutines.flow.Flow

internal interface TrainingProtocol {

    suspend fun setTraining(
        userId: String?,
        trainingId: String,
        trainingDto: TrainingDto
    ): Flow<Unit>

    suspend fun setShortTraining(
        userId: String?,
        trainingId: String,
        training: ShortTrainingDto
    ): Flow<Unit>

    suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTrainingDto>>

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
    ): Flow<List<TrainingDto>>

}