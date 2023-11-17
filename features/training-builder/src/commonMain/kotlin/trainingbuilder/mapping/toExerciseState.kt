package trainingbuilder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.state.Exercise

internal fun List<models.Exercise>.toState(): ImmutableList<Exercise> {
    return map {
        it.toState()
    }.toPersistentList()
}

internal fun models.Exercise.toState() = Exercise(
    id = id ?: "",
    name = name,
    iterations = iterations.toState(),
    volume = volume,
    repetitions = repetitions,
    intensity = intensity
)