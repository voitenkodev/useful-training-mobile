package repository

import dto.backend.AuthDTO
import dto.backend.TokenDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import source.datastore.PreferencesSource
import source.network.NetworkSource

class AuthRepositoryImpl(
    private val remote: NetworkSource,
    private val preferencesSource: PreferencesSource
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> =
        flow {
            emit(remote.login(AuthDTO(email, password)))
        }.map {
            val token = it.token
            if (token != null) preferencesSource.setToken(token)
        }

    override fun registration(email: String, password: String): Flow<TokenDTO> =
        flow {
            emit(remote.registration(AuthDTO(email, password)))
        }

    override fun getToken(): Flow<String?> =
        preferencesSource.getToken()

    override suspend fun logout() {
        preferencesSource.removeToken()
    }
}