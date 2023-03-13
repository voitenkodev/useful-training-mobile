package data.repository

import data.dto.AuthResponse
import kotlinx.coroutines.flow.Flow

internal interface AuthRepository {

    fun login(email: String, password: String): Flow<AuthResponse>

    fun registration(email: String, password: String): Flow<AuthResponse>

//    fun logout(): Flow<Unit>
//    val isAuthorized: Boolean
//    val userDto: UserDto?
}