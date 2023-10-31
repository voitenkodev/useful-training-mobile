import kotlinx.coroutines.flow.Flow

public interface AuthenticationRepository {
    public fun login(email: String, password: String): Flow<Unit>
    public fun registration(email: String, password: String): Flow<Unit>
    public fun getToken(): Flow<String?>
    public suspend fun logout()
}