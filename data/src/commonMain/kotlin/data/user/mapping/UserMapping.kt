package data.user.mapping

import models.ExperienceEnum
import models.User
import network.models.UserDto
import user.models.UserDao

internal fun UserDao.daoToDomain(): User {
    return User(
        id = id,
        name = name,
        email = email,
        weight = weight,
        experience = ExperienceEnum.of(experience),
        height = height
    )
}

internal fun UserDto.dtoToDao(): UserDao? {
    return UserDao(
        id = id ?: return null,
        name = name ?: return null,
        email = email ?: return null,
        weight = weight ?: return null,
        height = height ?: return null,
        experience = experience ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null
    )
}