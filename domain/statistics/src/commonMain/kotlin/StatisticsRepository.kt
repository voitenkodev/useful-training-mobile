import kotlinx.coroutines.flow.Flow
import models.ExerciseExampleAchievements

public interface StatisticsRepository {
    public fun getExerciseExampleAchievements(exerciseExampleId: String, size: Int): Flow<ExerciseExampleAchievements>
}