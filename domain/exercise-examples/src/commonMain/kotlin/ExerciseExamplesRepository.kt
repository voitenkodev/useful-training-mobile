import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.InputExerciseExample

public interface ExerciseExamplesRepository {
    public fun observeExerciseExamples(): Flow<List<ExerciseExample>>
    public fun syncExerciseExamples(): Flow<Unit>
    public fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample>
    public fun syncExerciseExampleById(exerciseExampleId: String): Flow<Unit>
    public fun setExerciseExample(exerciseExample: InputExerciseExample): Flow<Unit>
    public fun getRecommendedExerciseExamples(): Flow<List<ExerciseExample>>
    public fun clearCache()
}