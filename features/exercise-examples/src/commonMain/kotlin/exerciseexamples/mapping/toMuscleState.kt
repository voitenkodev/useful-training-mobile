package exerciseexamples.mapping

import exerciseexamples.state.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}