package data.source

import data.dto.UserDto
import kotlinx.coroutines.flow.Flow

internal class AuthSourceImpl : AuthProtocol {

    override fun login(email: String, password: String): Flow<UserDto> {
        TODO("Not yet implemented")
    }

    override fun registration(email: String, password: String): Flow<UserDto> {
        TODO("Not yet implemented")
    }

    override fun logout(): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override val isAuthorized: Boolean
        get() = TODO("Not yet implemented")
    override val userDto: UserDto?
        get() = TODO("Not yet implemented")
}