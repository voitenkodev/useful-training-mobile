import kotlinx.coroutines.flow.Flow
import models.Muscle
import models.MuscleType

public interface MusclesRepository {
    public fun observeMuscles(): Flow<List<MuscleType>>
    public fun syncUserMuscles(): Flow<Unit>
    public fun syncPublicMuscles(): Flow<Unit>
    public fun syncUserMuscleById(id: String): Flow<Unit>
    public fun observeMusclesById(ids: List<String>): Flow<List<Muscle>>
    public fun clearCache()
}