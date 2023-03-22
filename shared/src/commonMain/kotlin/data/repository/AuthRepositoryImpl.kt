package data.repository

import data.dto.AuthResponse
import data.source.network.AuthProtocol
import kotlinx.coroutines.flow.Flow

internal class AuthRepositoryImpl(
    private val authSource: AuthProtocol,
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> = authSource.login(email, password)

    override fun registration(email: String, password: String): Flow<AuthResponse> = authSource.registration(email, password)

//    override fun logout(): Flow<Unit> = authSource.logout() // .flowOn(dispatcher)

//    override val isAuthorized: Boolean = authSource.isAuthorized

//    override val userDto: UserDto? = authSource.userDto
}