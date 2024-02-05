import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.InputExerciseExample

public interface ExerciseExamplesRepository {
    public fun observeExerciseExamples(): Flow<List<ExerciseExample>>
    public fun getExerciseExamples(
        page: Int,
        size: Int,
        query: String? = null,
        weightType: String?= null,
        forceType: String?= null,
        experience: String?= null,
        category: String?= null,
        muscleIds: List<String> = emptyList(),
        equipmentIds: List<String> = emptyList()
    ): Flow<List<ExerciseExample>>
    public fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample>
    public fun syncExerciseExampleById(exerciseExampleId: String): Flow<Unit>
    public fun setExerciseExample(exerciseExample: InputExerciseExample): Flow<Unit>
    public fun getRecommendedExerciseExamples(): Flow<List<ExerciseExample>>
    public fun clearCache()
}