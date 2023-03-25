package data.source.network

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import co.touchlab.kermit.Logger
import data.dto.AuthBody
import data.dto.AuthResponse
import data.source.datastore.DataStoreKeys
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal interface AuthProtocol {
    fun login(email: String, password: String): Flow<Unit>
    fun registration(email: String, password: String): Flow<AuthResponse>

}

internal class AuthSource(
    private val network: HttpClient,
    private val dataStore: DataStore<Preferences>
) : AuthProtocol {

    override fun login(email: String, password: String): Flow<Unit> = flow {
        val result = network.post {
            url {
                path("/login")
                setBody(AuthBody(email, password))
            }
        }
        val token = result.body<AuthResponse>().token
        if (token != null) dataStore.edit { it[DataStoreKeys.KEY_TOKEN] = token }
        emit(Unit)
    }

    override fun registration(email: String, password: String): Flow<AuthResponse> = flow {
        val result = network.post {
            url {
                path("/register")
                setBody(AuthBody(email, password))
            }
        }
        emit(result.body<AuthResponse>())
    }

//    override fun logout(): Flow<Unit> = flow { emit(Unit) }
//
//    override val isAuthorized: Boolean = true
//
//    override val userDto: UserDto = UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev")
}
