package user.mapping

import kg
import meter
import models.User

public fun User.toState(): user.User {
    return user.User(
        name = name,
        email = email,
        experience = experience.toState(),
        height = height.meter(allowUnit = true),
        weight = weight.kg(allowUnit = true)
    )
}