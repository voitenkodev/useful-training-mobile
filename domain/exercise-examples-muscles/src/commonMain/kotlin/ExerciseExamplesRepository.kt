import kotlinx.coroutines.flow.Flow
import models.ExerciseExample

public interface ExerciseExamplesRepository {

    // Exercise examples
    public fun observeExerciseExamples(): Flow<List<ExerciseExample>>
    public fun syncExerciseExamples(): Flow<Unit>
    public fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample>
    public fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit>
    public fun getRecommendedExerciseExamples(): Flow<List<ExerciseExample>>
    public fun clearCache()
}