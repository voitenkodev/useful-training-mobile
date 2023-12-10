package searchexercise.main.mapping

import searchexercise.main.state.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}