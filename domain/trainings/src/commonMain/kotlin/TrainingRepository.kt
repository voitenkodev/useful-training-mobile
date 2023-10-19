import kotlinx.coroutines.flow.Flow
import models.ExerciseDate
import models.Training

public interface TrainingRepository {

    public suspend fun getTrainings(): Flow<List<Training>>

    public suspend fun getExercises(query: String): Flow<List<ExerciseDate>>

    public suspend fun getTraining(trainingId: String): Flow<Training>

    public suspend fun setTraining(training: Training): Flow<String>

    public suspend fun deleteTraining(trainingId: String): Flow<Unit>

    public suspend fun getExerciseNameOptions(): Flow<List<String>>

    public suspend fun setExerciseNameOptions(names: List<String>): Flow<Unit>

    public suspend fun removeExerciseNameOption(value: String): Flow<String>
}