import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.Muscle
import models.MuscleType

public interface ExerciseExamplesRepository {

    // Exercise examples
    public fun observeExerciseExamples(): Flow<List<ExerciseExample>>
    public fun syncExerciseExamples(): Flow<Unit>
    public fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample>
    public fun recommendedExerciseExample(): Flow<List<ExerciseExample>>
    public fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit>

    // Muscles
    public fun observeMuscleTypes(): Flow<List<MuscleType>>
    public fun observeMusclesById(ids: List<String>): Flow<List<Muscle>>
    public fun syncMuscleTypes(): Flow<Unit>
    public fun clearCache()
}