package data.repository

import data.dto.ExerciseDateDTO
import data.dto.TrainingDTO
import kotlinx.coroutines.flow.Flow

internal interface TrainingRepository {

    suspend fun getTrainings(): Flow<List<TrainingDTO>>

    suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>>

    suspend fun getTraining(trainingId: String): Flow<TrainingDTO>

    suspend fun setTraining(training: TrainingDTO): Flow<String>

    suspend fun removeTraining(trainingId: String): Flow<Unit>
    suspend fun getExerciseNames(): Flow<List<String>>
    suspend fun setExerciseNames(names: List<String>): Flow<Unit>
    suspend fun removeExerciseName(names: List<String>): Flow<Unit>
}