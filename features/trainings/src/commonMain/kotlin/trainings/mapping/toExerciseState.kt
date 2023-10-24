package trainings.mapping

import kotlinx.collections.immutable.toImmutableList
import trainings.state.Exercise

internal fun List<models.Exercise>.toState() = this
    .map { it.toState() }
    .toImmutableList()

internal fun models.Exercise.toState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.toState(),
    tonnage = tonnage ?: 0.0,
)