package user.mapping

import data.User
import user.models.UserDao

internal fun User.toDao(): UserDao {
    return UserDao(
        id = id,
        name = name ?: "",
        email = email ?: "",
        weight = weight?.toInt() ?: 0,
        height = height?.toInt() ?: 0,
        updatedAt = updatedAt ?: "",
        createdAt = createdAt ?: ""
    )
}