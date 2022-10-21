package data.repository

import data.dto.ShortTraining
import data.dto.Training
import kotlinx.coroutines.flow.Flow

interface TrainingRepository {

    suspend fun getShortTrainings(): Flow<List<ShortTraining>>
    suspend fun getTrainings(): Flow<List<Training>>
    suspend fun setTraining(training: Training): Flow<Training>
    suspend fun removeTraining(trainingId: String): Flow<Unit>
}