import kotlinx.coroutines.flow.Flow
import models.Training

public interface TrainingsRepository {
    public fun observeTrainings(startDate: String, endDate: String): Flow<List<Training>>
    public fun syncTrainings(startDate: String, endDate: String): Flow<Unit>
    public fun observeTraining(trainingId: String): Flow<Training?>
    public fun setTraining(training: Training): Flow<String?>
    public fun deleteTraining(trainingId: String): Flow<Unit>
}