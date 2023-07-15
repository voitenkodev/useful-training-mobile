package data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import data.dto.TokenDTO
import data.source.datastore.DataStoreKeys
import data.source.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class AuthRepositoryImpl(
    private val remote: RemoteDataSource,
    private val dataStore: DataStore<Preferences>
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> =
        remote
            .login(email, password)
            .map {
                val token = it.token
                if (token != null) dataStore.edit { it[DataStoreKeys.KEY_TOKEN] = token }
            }

    override fun registration(email: String, password: String): Flow<TokenDTO> =
        remote
            .registration(email, password)

}