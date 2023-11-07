import kotlinx.coroutines.flow.Flow
import models.User

public interface UserRepository {
    public fun observeUser(): Flow<User>
    public fun syncUser(): Flow<Unit>
    public fun clearCache()
}