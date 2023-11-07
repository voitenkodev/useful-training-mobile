package authentication.repository

import AuthenticationRepository
import NetworkSource
import PreferencesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.AuthDto
import models.RegisterDto
import traininig_exercise_iteration.TrainingsSource

internal class AuthenticationRepositoryImpl(
    private val remote: NetworkSource,
    private val preferences: PreferencesSource,
    private val local: TrainingsSource
) : AuthenticationRepository {

    override fun registration(email: String, password: String, weight: Int, height: Int, name: String): Flow<Unit> {
        return flow {
            val dto = RegisterDto(
                email = email,
                password = password,
                weight = weight,
                height = height,
                name = name
            )
            emit(remote.register(dto))
        }.map {
            val token = it.accessToken
            if (token != null) preferences.setToken(token)

        }
    }

    override fun login(email: String, password: String): Flow<Unit> =
        flow {
            emit(remote.login(AuthDto(email, password)))
        }.map {
            val token = it.accessToken
            if (token != null) preferences.setToken(token)
        }

    override fun getToken(): Flow<String?> =
        preferences.getToken()

    override suspend fun logout() {
        preferences.removeToken()
        local.dropTable()
    }
}