import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.Muscle

public interface ExerciseExamplesRepository {

    public fun getExerciseExampleWithMusclesById(exerciseExampleId: Long): Flow<Pair<ExerciseExample, List<Muscle>>?>

    public fun getMuscleWithExerciseExamplesById(muscleId: Long): Flow<Pair<Muscle, List<ExerciseExample>>?>

    public fun setExerciseExampleWithMuscles(exerciseExample: ExerciseExample, muscles: List<Muscle>)

    public fun setMuscleWithExerciseExamples(muscle: Muscle, exerciseExamples: List<ExerciseExample>)
}