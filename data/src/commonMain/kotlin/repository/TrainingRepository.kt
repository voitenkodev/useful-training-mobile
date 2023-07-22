package repository

import dto.ExerciseDateDTO
import dto.TrainingDTO
import kotlinx.coroutines.flow.Flow

interface TrainingRepository {

    suspend fun getTrainings(): Flow<List<TrainingDTO>>

    suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>>

    suspend fun getTraining(trainingId: String): Flow<TrainingDTO>

    suspend fun setTraining(training: TrainingDTO): Flow<String>

    suspend fun removeTraining(trainingId: String): Flow<Unit>

    suspend fun getExerciseNameOptions(): Flow<List<String>>

    suspend fun setExerciseNameOptions(names: List<String>): Flow<Unit>

    suspend fun removeExerciseNameOption(value: String): Flow<String>
}