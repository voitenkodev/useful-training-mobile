import kotlinx.coroutines.flow.Flow
import models.ExerciseDate
import models.Training

interface TrainingRepository {

    suspend fun getTrainings(): Flow<List<Training>>

    suspend fun getExercises(query: String): Flow<List<ExerciseDate>>

    suspend fun getTraining(trainingId: String): Flow<Training>

    suspend fun setTraining(training: Training): Flow<String>

    suspend fun deleteTraining(trainingId: String): Flow<Unit>

    suspend fun getExerciseNameOptions(): Flow<List<String>>

    suspend fun setExerciseNameOptions(names: List<String>): Flow<Unit>

    suspend fun removeExerciseNameOption(value: String): Flow<String>
}