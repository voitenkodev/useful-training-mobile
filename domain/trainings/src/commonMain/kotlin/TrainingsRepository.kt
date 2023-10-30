import kotlinx.coroutines.flow.Flow
import models.Training

public interface TrainingsRepository {
    public fun getTrainings(startDate: String, endDate: String): Flow<List<Training>>
    public fun getTraining(trainingId: String): Flow<Training?>
    public fun setTraining(training: Training): Flow<String?>
    public fun deleteTraining(trainingId: String): Flow<Unit>
}