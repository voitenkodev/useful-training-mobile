package trainingbuilder.mapping

import trainingbuilder.state.Exercise

internal fun List<models.Exercise>.toExerciseStateList() = this.map { it.toExerciseState() }

internal fun models.Exercise.toExerciseState() = Exercise(
    id = id ?: "",
    name = name,
    iterations = iterations.toIterationStateList(),
    volume = volume,
    repetitions = repetitions,
    intensity = intensity
)