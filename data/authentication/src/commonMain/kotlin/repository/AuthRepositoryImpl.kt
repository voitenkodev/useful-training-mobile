package repository

import AuthRepository
import DataBaseSource
import NetworkSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import mappers.toDomain
import models.AuthDto
import models.Token
import PreferencesSource

class AuthRepositoryImpl(
    private val remote: NetworkSource,
    private val preferences: PreferencesSource,
    private val local: DataBaseSource
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> =
        flow {
            emit(remote.login(AuthDto(email, password)))
        }.map {
            val token = it.token
            if (token != null) preferences.setToken(token)
        }

    override fun registration(email: String, password: String): Flow<Token> =
        flow {
            emit(remote.registration(AuthDto(email, password)))
        }.map { it.toDomain() }

    override fun getToken(): Flow<String?> =
        preferences.getToken()

    override suspend fun logout() {
        preferences.removeToken()
        local.deleteAll()
    }
}