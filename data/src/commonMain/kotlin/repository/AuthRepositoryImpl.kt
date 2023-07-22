package repository

import dto.TokenDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import source.datastore.PreferencesSource
import source.network.NetworkSource

class AuthRepositoryImpl(
    private val remote: NetworkSource,
    private val preferencesSource: PreferencesSource
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> =
        remote
            .login(email, password)
            .map {
                val token = it.token
                if (token != null) preferencesSource.setToken(token)
            }

    override fun registration(email: String, password: String): Flow<TokenDTO> =
        remote
            .registration(email, password)

    override suspend fun setToken(value: String) {
        preferencesSource.setToken(value)
    }

    override fun getToken(): Flow<String?> =
        preferencesSource.getToken()
}