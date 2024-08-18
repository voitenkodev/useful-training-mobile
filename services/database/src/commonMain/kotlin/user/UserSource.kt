package user

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import user.mapping.toDao
import user.models.UserDao
import user.models.WeightHistoryDao

public class UserSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val userApi by lazy { database.userQueries }
    private val weightApi by lazy { database.weightHistoryQueries }

    public fun getUser(): Flow<UserDao?> {
        return userApi
            .getUser()
            .asFlow()
            .mapToOne(Dispatchers.Default)
            .map { it.toDao() }
    }

    public fun getWeightHistory(): Flow<List<WeightHistoryDao>> {
        return weightApi
            .getWeightHistory()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { item -> item.map { it.toDao() } }
    }

    public fun getLastWeight(): Flow<WeightHistoryDao> {
        return weightApi
            .getLastWeightHistory()
            .asFlow()
            .mapToOne(Dispatchers.Default)
            .map { item -> item.toDao() }
    }

    public fun setUser(userDao: UserDao) {
        userApi
            .setUser(
                id = userDao.id,
                email = userDao.email,
                weight = userDao.weight,
                height = userDao.height,
                name = userDao.name,
                experience = userDao.experience,
                updatedAt = userDao.updatedAt,
                createdAt = userDao.createdAt
            )
    }

    public fun setWeightHistories(list: List<WeightHistoryDao>) {
        userApi.transaction {
            weightApi.deleteTableWeightHistory()
            list.forEach { item -> setWeightHistory(item) }
        }
    }

    public fun setWeightHistory(dao: WeightHistoryDao) {
        weightApi.setWeightHistory(
            id = dao.id,
            weight = dao.weight,
            updatedAt = dao.updatedAt,
            createdAt = dao.createdAt
        )
    }

    public fun clearTable() {
        userApi.deleteTableUser()
        weightApi.deleteTableWeightHistory()
    }
}