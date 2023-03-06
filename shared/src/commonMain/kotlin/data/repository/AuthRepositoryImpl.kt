package data.repository

import data.dto.UserDto
import data.source.AuthProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

internal class AuthRepositoryImpl(
    private val authSource: AuthProtocol,
//    private val dispatcher: CoroutineContext
) : AuthRepository {

    override fun login(email: String, password: String): Flow<UserDto> = authSource.login(email, password) // .flowOn(dispatcher)

    override fun registration(email: String, password: String): Flow<UserDto> = authSource.registration(email, password) // .flowOn(dispatcher)

    override fun logout(): Flow<Unit> = authSource.logout() // .flowOn(dispatcher)

    override val isAuthorized: Boolean = authSource.isAuthorized

    override val userDto: UserDto? = authSource.userDto
}