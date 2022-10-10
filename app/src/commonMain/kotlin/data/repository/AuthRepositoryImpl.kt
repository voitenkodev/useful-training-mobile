package data.repository

import data.dto.User
import data.source.AuthProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class AuthRepositoryImpl(
    private val authSource: AuthProtocol,
    private val dispatcher: CoroutineContext
) : AuthRepository {

    override fun login(email: String, password: String): Flow<User> = authSource.login(email, password).flowOn(dispatcher)

    override fun registration(email: String, password: String): Flow<User> = authSource.registration(email, password).flowOn(dispatcher)

    override fun logout(): Flow<Unit> = authSource.logout().flowOn(dispatcher)

    override val isAuthorized: Boolean = authSource.isAuthorized

    override val user: User? = authSource.user
}