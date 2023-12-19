package profile.main.mapping

import kg
import meter
import profile.main.models.User

internal fun models.User.toState(): User {
    return User(
        name = name,
        weight = weight.kg(true),
        height = height.meter(true)
    )
}