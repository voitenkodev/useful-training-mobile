package data.source

import data.dto.User
import kotlinx.coroutines.flow.Flow

interface AuthProtocol {

    fun login(email: String, password: String): Flow<User>

    fun registration(email: String, password: String): Flow<User>

    fun logout(): Flow<Unit>

    val isAuthorized: Boolean

    val user: User?
}