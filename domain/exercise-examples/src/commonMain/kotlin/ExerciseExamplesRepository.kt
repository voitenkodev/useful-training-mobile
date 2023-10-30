import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.Muscle

public interface ExerciseExamplesRepository {
    public fun getExerciseExamples(): Flow<List<ExerciseExample>>
    public fun getExerciseExample(exerciseExampleId: String): Flow<ExerciseExample?>
    public fun getMuscles(): Flow<List<Muscle>>
    public fun setExerciseExample(exerciseExample: ExerciseExample): Flow<Unit>
}