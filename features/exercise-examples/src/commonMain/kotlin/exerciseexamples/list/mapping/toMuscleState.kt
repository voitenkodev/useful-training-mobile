package exerciseexamples.list.mapping

import exerciseexamples.list.models.Muscle

internal fun models.Muscle.toState(): Muscle {
    return Muscle(
        id = id,
        name = name
    )
}