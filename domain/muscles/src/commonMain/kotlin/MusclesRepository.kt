import kotlinx.coroutines.flow.Flow
import models.Muscle
import models.MuscleType

public interface MusclesRepository {
    public fun observeMuscleTypes(): Flow<List<MuscleType>>
    public fun syncMuscleTypes(): Flow<Unit>
    public fun observeMusclesById(ids: List<String>): Flow<List<Muscle>>
    public fun clearCache()
}