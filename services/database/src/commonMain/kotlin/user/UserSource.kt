package user

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOne
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import user.mapping.toDao
import user.models.UserDao

public class UserSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val api by lazy { database.userQueries }

    public fun getUser(): Flow<UserDao> {
        return api
            .getUser()
            .asFlow()
            .mapToOne(Dispatchers.Default)
            .map { it.toDao() }
    }

    public fun setUser(userDao: UserDao) {
        api
            .setUser(
                id = userDao.id,
                email = userDao.email,
                weight = userDao.weight.toLong(),
                height = userDao.height.toLong(),
                name = userDao.name,
                updatedAt = userDao.updatedAt,
                createdAt = userDao.createdAt
            )
    }

    public fun clearTable() {
        api.deleteTableUser()
    }
}