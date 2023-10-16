import kotlinx.coroutines.flow.Flow
import models.Token

interface AuthRepository {

    fun login(email: String, password: String): Flow<Unit>

    fun registration(email: String, password: String): Flow<Token>

    fun getToken(): Flow<String?>

    suspend fun logout()
}