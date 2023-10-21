package trainings.mapping

import kotlinx.collections.immutable.toImmutableList
import trainings.state.Exercise

internal fun List<models.Exercise>.toExerciseStateList() = this
    .map { it.toExerciseState() }
    .toImmutableList()

internal fun models.Exercise.toExerciseState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.toIterationStateList(),
    tonnage = tonnage ?: 0.0,
)