import kotlinx.coroutines.flow.Flow
import models.ExerciseExampleFilters

public interface FiltersRepository {
    public fun getExerciseExampleFilters(): Flow<ExerciseExampleFilters>
}