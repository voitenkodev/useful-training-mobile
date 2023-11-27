package profile.main.mapping

import kg
import meter
import profile.main.state.User

internal fun models.User.toState(): User {
    return User(
        name = name,
        weight = weight.kg(),
        height = height.meter()
    )
}