package statistics.mapping

import statistics.state.Exercise

internal fun models.Exercise.toState(): Exercise? {
    return Exercise(
        id = id ?: return null,
        name = name,
        iterations = iterations.toState(),
        tonnage = tonnage
    )
}