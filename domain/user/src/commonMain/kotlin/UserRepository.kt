import kotlinx.coroutines.flow.Flow
import models.User
import models.UserWeights

public interface UserRepository {
    public fun observeUser(): Flow<User>
    public fun syncUser(): Flow<Unit>
    public fun observeUserWeights(): Flow<List<UserWeights>>
    public fun syncUserWeights(): Flow<Unit>
    public fun clearCache()
}