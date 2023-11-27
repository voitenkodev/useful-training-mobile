package exerciseexamples.list.mapping

import exerciseexamples.list.state.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}