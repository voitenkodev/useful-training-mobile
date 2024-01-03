import kotlinx.coroutines.flow.Flow
import models.User
import models.WeightHistory

public interface UserRepository {
    public fun observeUser(): Flow<User>
    public fun syncUser(): Flow<Unit>

    public fun observeWeightHistory(): Flow<List<WeightHistory>>
    public fun syncWeightHistory(): Flow<Unit>
    public fun updateWeight(value: Double): Flow<Unit>

    public fun setExcludedMuscle(id: String): Flow<String?>
    public fun deleteExcludedMuscle(id: String): Flow<String?>

    public fun clearCache()
}