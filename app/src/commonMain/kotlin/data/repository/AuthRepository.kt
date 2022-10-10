package data.repository

import data.dto.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(email: String, password: String): Flow<User>
    fun registration(email: String, password: String): Flow<User>
    fun logout(): Flow<Unit>
    val isAuthorized: Boolean
    val user: User?
}