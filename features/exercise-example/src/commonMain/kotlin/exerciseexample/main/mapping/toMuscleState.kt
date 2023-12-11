package exerciseexample.main.mapping

import exerciseexample.main.state.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}