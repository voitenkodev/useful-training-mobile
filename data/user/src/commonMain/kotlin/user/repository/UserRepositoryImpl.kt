package user.repository

import NetworkSource
import UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.User
import user.UserSource
import user.mapping.daoToDomain
import user.mapping.dtoToDao

internal class UserRepositoryImpl(
    private val remote: NetworkSource,
    private val local: UserSource
) : UserRepository {

    override fun observeUser(): Flow<User> {
        return local
            .getUser()
            .map { it.daoToDomain() }
    }

    override fun syncUser(): Flow<Unit> {
        return flow {
            val result = remote.getUser().dtoToDao()
            if (result != null) local.setUser(result)
            emit(Unit)
        }
    }
}