package data.source

import data.dto.User
import kotlinx.coroutines.flow.Flow

class AuthSourceImpl : AuthProtocol {

    override fun login(email: String, password: String): Flow<User> {
        TODO("Not yet implemented")
    }

    override fun registration(email: String, password: String): Flow<User> {
        TODO("Not yet implemented")
    }

    override fun logout(): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override val isAuthorized: Boolean
        get() = TODO("Not yet implemented")
    override val user: User?
        get() = TODO("Not yet implemented")
}