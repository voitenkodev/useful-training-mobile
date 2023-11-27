package trainingbuilder.builder.mapping

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.builder.state.Exercise

internal fun List<models.Exercise>.toState(): PersistentList<Exercise> {
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