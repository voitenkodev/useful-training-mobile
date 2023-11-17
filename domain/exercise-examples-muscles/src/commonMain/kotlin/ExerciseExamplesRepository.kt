import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.MuscleType

public interface ExerciseExamplesRepository {

    // Exercise examples
    public fun observeExerciseExamples(): Flow<List<ExerciseExample>>
    public fun syncExerciseExamples(): Flow<Unit>
    public fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample>

    // Muscles
    public fun observeMuscles(): Flow<List<MuscleType>>
    public fun syncMuscles(): Flow<Unit>
    public fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit>
    public fun clearCache()
}