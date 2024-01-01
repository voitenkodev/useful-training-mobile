package data.user.repository

import NetworkSource
import UserRepository
import data.user.mapping.daoToDomain
import data.user.mapping.dtoToDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.User
import models.UserWeights
import user_weight.UserSource

internal class UserRepositoryImpl(
    private val remote: NetworkSource,
    private val local: UserSource
) : UserRepository {

    override fun observeUser(): Flow<User> {
        return local
            .getUser()
            .map { it?.daoToDomain() }
            .filterNotNull()
    }

    override fun syncUser(): Flow<Unit> {
        return flow {
            val result = remote.getUser().dtoToDao()
            if (result != null) local.setUser(result)
            emit(Unit)
        }
    }

    override fun observeUserWeights(): Flow<List<UserWeights>> {
        return local
            .getUserWeights()
            .map { it.daoToDomain() }
    }

    override fun syncUserWeights(): Flow<Unit> {
        return flow {
            val result = remote.getUserWeights().dtoToDao()
            local.setUserWeights(result)
            emit(Unit)
        }
    }

    override fun clearCache() {
        local.clearTable()
    }
}