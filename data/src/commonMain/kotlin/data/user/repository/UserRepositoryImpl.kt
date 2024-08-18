package data.user.repository

import UserRepository
import data.user.mapping.daoToDomain
import data.user.mapping.dtoToDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.User
import models.WeightHistory
import network.NetworkSource
import user.UserSource

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

    override fun observeWeightHistory(): Flow<List<WeightHistory>> {
        return local
            .getWeightHistory()
            .map { it.daoToDomain() }
    }

    override fun observeLastWeight(): Flow<WeightHistory> {
        return local
            .getLastWeight()
            .map { it.daoToDomain() }
    }

    override fun syncWeightHistory(): Flow<Unit> {
        return flow {
            val result = remote.getWeightHistory().dtoToDao()
            local.setWeightHistories(result)
            emit(Unit)
        }
    }

    override fun removeWeight(id: String): Flow<Unit> {
        return flow {
            val result = remote.removeWeight(id)
            emit(result)
        }
    }

    override fun updateWeight(value: Double): Flow<Unit> {
        return flow {
            val result = remote.updateWeightHistory(value).dtoToDao()
            if (result != null) local.setWeightHistory(result)
            emit(Unit)
        }
    }

    override fun setExcludedMuscle(id: String): Flow<String?> {
        return flow {
            val result = remote.setExcludedMuscle(id).id
            emit(result)
        }
    }

    override fun deleteExcludedMuscle(id: String): Flow<String?> {
        return flow {
            val result = remote.deleteExcludedMuscle(id).id
            emit(result)
        }
    }

    override fun setExcludedEquipment(id: String): Flow<String?> {
        return flow {
            val result = remote.setExcludedEquipment(id).id
            emit(result)
        }
    }

    override fun deleteExcludedEquipment(id: String): Flow<String?> {
        return flow {
            val result = remote.deleteExcludedEquipment(id).id
            emit(result)
        }
    }

    override fun clearCache() {
        local.clearTable()
    }
}