import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.Muscle

public interface ExerciseExamplesRepository {
    public fun observeExerciseExamples(): Flow<List<ExerciseExample>>
    public fun observeExerciseExample(exerciseExampleId: String): Flow<ExerciseExample?>
    public fun observeMuscles(): Flow<List<Muscle>>
    public fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit>
    public fun syncExerciseExamples(): Flow<Unit>
    public fun syncMuscles(): Flow<Unit>
}
