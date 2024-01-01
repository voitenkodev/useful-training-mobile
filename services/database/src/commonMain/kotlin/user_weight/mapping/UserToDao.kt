package user_weight.mapping

import data.User
import user_weight.models.UserDao

internal fun User.toDao(): UserDao {
    return UserDao(
        id = id,
        name = name ?: "",
        email = email ?: "",
        weight = weight ?: 0.0,
        height = height ?: 0.0,
        updatedAt = updatedAt ?: "",
        createdAt = createdAt ?: ""
    )
}