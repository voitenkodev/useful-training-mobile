package exerciseexample.main.mapping

import exerciseexample.main.models.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}