package trainingbuilder.training_builder.mapping

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.training_builder.models.BuildExercise

internal fun List<models.Exercise>.toState(): PersistentList<BuildExercise> {
    return map {
        it.toState()
    }.toPersistentList()
}

internal fun models.Exercise.toState() = BuildExercise(
    id = id ?: "",
    name = name,
    buildIterations = iterations.toState(),
    volume = volume,
    repetitions = repetitions,
    intensity = intensity
)