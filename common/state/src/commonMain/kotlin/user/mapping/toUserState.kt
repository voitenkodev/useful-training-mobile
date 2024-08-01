package user.mapping

import kg
import meter
import models.User

public fun User.toUserState(): user.User {
    return user.User(
        name = name,
        email = email,
        experience = experience.toExperienceEnumState(),
        height = height.meter(allowUnit = true),
        weight = weight.kg(allowUnit = true)
    )
}