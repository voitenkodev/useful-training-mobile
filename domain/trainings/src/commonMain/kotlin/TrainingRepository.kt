import kotlinx.coroutines.flow.Flow
import models.ExerciseDate
import models.Training

public interface TrainingRepository {

    public fun getTrainings(): Flow<List<Training>>

    public fun getExercises(query: String): Flow<List<ExerciseDate>>

    public fun getTraining(trainingId: String): Flow<Training>

    public fun setTraining(training: Training): Flow<String>

    public fun deleteTraining(trainingId: String): Flow<Unit>
}