package data.source

import data.dto.UserDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class AuthSource : AuthProtocol {

    override fun login(email: String, password: String): Flow<UserDto> = flow {
        emit(UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun registration(email: String, password: String): Flow<UserDto> = flow {
        emit(UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun logout(): Flow<Unit> = flow { emit(Unit) }

    override val isAuthorized: Boolean = true

    override val userDto: UserDto = UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev")
}
