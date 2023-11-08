package profile.mapping

import kg
import meter
import profile.state.User

internal fun models.User.toState(): User {
    return User(
        name = name,
        weight = weight.kg(),
        height = height.meter()
    )
}