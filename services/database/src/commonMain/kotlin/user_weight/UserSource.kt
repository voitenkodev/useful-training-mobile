package user_weight

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import user_weight.mapping.toDao
import user_weight.models.UserDao
import user_weight.models.WeightHistoryDao

public class UserSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val api by lazy { database.user_weightQueries }

    public fun getUser(): Flow<UserDao?> {
        return api
            .getUser()
            .asFlow()
            .mapToOne(Dispatchers.Default)
            .map { it.toDao() }
    }

    public fun getWeightHistory(): Flow<List<WeightHistoryDao>> {
        return api
            .getWeightHistory()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { item -> item.map { it.toDao() } }
    }

    public fun setUser(userDao: UserDao) {
        api
            .setUser(
                id = userDao.id,
                email = userDao.email,
                weight = userDao.weight,
                height = userDao.height,
                name = userDao.name,
                updatedAt = userDao.updatedAt,
                createdAt = userDao.createdAt
            )
    }

    public fun setWeightHistories(list: List<WeightHistoryDao>) {
        api.transaction {
            list.forEach { item -> setWeightHistory(item) }
        }
    }

    public fun setWeightHistory(dao: WeightHistoryDao) {
        api
            .setWeightHistory(
                id = dao.id,
                weight = dao.weight,
                updatedAt = dao.updatedAt,
                createdAt = dao.createdAt
            )
    }

    public fun clearTable() {
        api.deleteTableUser()
        api.deleteTableWeightHistory()
    }
}