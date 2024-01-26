package user.mapping

import data.User
import user.models.UserDao

internal fun User.toDao(): UserDao {
    return UserDao(
        id = id,
        name = name,
        email = email,
        weight = weight,
        height = height,
        updatedAt = updatedAt,
        experience = experience,
        createdAt = createdAt
    )
}