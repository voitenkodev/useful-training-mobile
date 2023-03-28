package data.repository

import data.dto.TokenDTO
import kotlinx.coroutines.flow.Flow

internal interface AuthRepository {

    fun login(email: String, password: String): Flow<Unit>

    fun registration(email: String, password: String): Flow<TokenDTO>

//    fun logout(): Flow<Unit>
//    val isAuthorized: Boolean
//    val userDto: UserDto?
}