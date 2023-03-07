package data.source

import data.dto.ShortTrainingDto
import data.dto.TrainingDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class TrainingSource : TrainingProtocol {
    override suspend fun setTraining(
        userId: String?,
        trainingId: String,
        trainingDto: TrainingDto
    ): Flow<Unit> = flow { emit(Unit) }

    override suspend fun removeTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit) }

    override suspend fun removeShortTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit) }

    override suspend fun getTrainings(
        userId: String?,
    ): Flow<List<TrainingDto>> = flow { emit(emptyList()) }

    override suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTrainingDto>> = flow { emit(emptyList()) }

    override suspend fun setShortTraining(
        userId: String?,
        trainingId: String,
        training: ShortTrainingDto
    ): Flow<Unit> = flow { emit(Unit) }
}