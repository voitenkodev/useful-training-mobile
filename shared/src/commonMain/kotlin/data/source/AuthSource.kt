package data.source

import data.dto.AuthBody
import data.dto.AuthResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class AuthSource(private val client: HttpClient) : AuthProtocol {

    override fun login(email: String, password: String): Flow<AuthResponse> = flow {
        val result = client.post {
            url {
                path("/login")
                setBody(AuthBody(email, password))
            }
        }
        emit(result.body())
    }

    override fun registration(email: String, password: String): Flow<AuthResponse> = flow {
        val result = client.post {
            url {
                path("/register")
                setBody(AuthBody(email, password))
            }
        }
        emit(result.body())
    }

//    override fun registration(email: String, password: String): Flow<UserDto> = flow {
//        emit(UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev"))
//    }
//
//    override fun logout(): Flow<Unit> = flow { emit(Unit) }
//
//    override val isAuthorized: Boolean = true
//
//    override val userDto: UserDto = UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev")
}
