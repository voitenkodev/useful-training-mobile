package data.source

import data.dto.UserDto
import kotlinx.coroutines.flow.Flow

internal interface AuthProtocol {

    fun login(email: String, password: String): Flow<UserDto>

    fun registration(email: String, password: String): Flow<UserDto>

    fun logout(): Flow<Unit>

    val isAuthorized: Boolean

    val userDto: UserDto?
}