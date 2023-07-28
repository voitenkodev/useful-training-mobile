package repository

import dto.TokenDTO
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(email: String, password: String): Flow<Unit>

    fun registration(email: String, password: String): Flow<TokenDTO>

    suspend fun setToken(value: String)

    fun getToken(): Flow<String?>

    suspend fun logout()
}