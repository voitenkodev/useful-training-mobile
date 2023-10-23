import kotlinx.coroutines.flow.Flow

public interface ExercisesBundleRepository {

    public fun getExerciseNameOptions(): Flow<List<String>>

    public fun setExerciseNameOptions(names: List<String>): Flow<Unit>

    public fun removeExerciseNameOption(value: String): Flow<String>
}