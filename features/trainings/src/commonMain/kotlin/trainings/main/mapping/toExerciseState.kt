package trainings.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import trainings.main.models.Exercise

internal fun List<models.Exercise>.toState(): ImmutableList<Exercise> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.Exercise.toState(): Exercise? {
    return Exercise(
        id = id ?: return null,
        name = name,
        iterations = iterations.toState(),
        volume = volume
    )
}