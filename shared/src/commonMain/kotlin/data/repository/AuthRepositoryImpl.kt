package data.repository

import data.dto.TokenDTO
import data.source.network.AuthProtocol
import kotlinx.coroutines.flow.Flow

internal class AuthRepositoryImpl(
    private val authSource: AuthProtocol,
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> = authSource.login(email, password)

    override fun registration(email: String, password: String): Flow<TokenDTO> = authSource.registration(email, password)

}