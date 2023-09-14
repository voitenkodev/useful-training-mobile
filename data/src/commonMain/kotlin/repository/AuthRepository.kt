package repository

import dto.backend.TokenDTO
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(email: String, password: String): Flow<Unit>

    fun registration(email: String, password: String): Flow<TokenDTO>

    fun getToken(): Flow<String?>

    suspend fun logout()
}