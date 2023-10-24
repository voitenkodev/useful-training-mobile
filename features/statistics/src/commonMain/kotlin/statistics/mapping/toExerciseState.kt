package statistics.mapping

import statistics.state.Exercise

internal fun models.Exercise.toState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.toState(),
    tonnage = tonnage ?: 0.0,
)