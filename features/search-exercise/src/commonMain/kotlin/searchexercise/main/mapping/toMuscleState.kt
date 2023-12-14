package searchexercise.main.mapping

import searchexercise.main.models.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}