import kotlinx.coroutines.flow.Flow

public interface ExerciseExamplesRepository {

    public fun getExerciseNameOptions(): Flow<List<String>>

    public fun setExerciseNameOptions(names: List<String>): Flow<Unit>

    public fun removeExerciseNameOption(value: String): Flow<String>
}