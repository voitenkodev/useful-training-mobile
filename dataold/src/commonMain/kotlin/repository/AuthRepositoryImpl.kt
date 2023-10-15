package repository

import dto.backend.AuthDTO
import dto.backend.TokenDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import source.database.DataBaseSource
import source.datastore.PreferencesSource
import source.network.NetworkSource

class AuthRepositoryImpl(
    private val remote: NetworkSource,
    private val preferences: PreferencesSource,
    private val local: DataBaseSource
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> =
        flow {
            emit(remote.login(AuthDTO(email, password)))
        }.map {
            val token = it.token
            if (token != null) preferences.setToken(token)
        }

    override fun registration(email: String, password: String): Flow<TokenDTO> =
        flow {
            emit(remote.registration(AuthDTO(email, password)))
        }

    override fun getToken(): Flow<String?> =
        preferences.getToken()

    override suspend fun logout() {
        preferences.removeToken()
        local.deleteAll()
    }
}