package trainings.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import trainings.Exercise

public fun List<models.Exercise>.toState(): ImmutableList<Exercise> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

public fun models.Exercise.toState(): Exercise? {
    return Exercise(
        id = id ?: return null,
        name = name,
        iterations = iterations.toState(),
        volume = volume
    )
}