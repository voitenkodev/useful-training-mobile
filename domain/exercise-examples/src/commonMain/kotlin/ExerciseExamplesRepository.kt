import kotlinx.coroutines.flow.Flow
import models.ExerciseExample
import models.Muscle

public interface ExerciseExamplesRepository {

    public fun getExerciseExamples(): Flow<List<ExerciseExample>>

    public fun getMuscles(): Flow<List<Muscle>>

    public fun getExerciseExampleWithMusclesById(exerciseExampleId: String): Flow<Pair<ExerciseExample, List<Muscle>>>

    public fun getMuscleWithExerciseExamplesById(muscleId: String): Flow<Pair<Muscle, List<ExerciseExample>>>

    public fun setExerciseExampleWithMuscles(exerciseExample: ExerciseExample, muscles: List<Muscle>)

    public fun setMuscleWithExerciseExamples(muscle: Muscle, exerciseExamples: List<ExerciseExample>)

    public fun deleteMuscle(muscleId: String)

    public fun deleteExerciseExample(exerciseExampleId: String)
}