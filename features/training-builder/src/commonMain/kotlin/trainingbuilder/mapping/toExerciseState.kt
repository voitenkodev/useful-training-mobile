package trainingbuilder.mapping

import trainingbuilder.state.Exercise

internal fun List<models.Exercise>.toExerciseStateList() = this.map { it.toExerciseState() }

internal fun models.Exercise.toExerciseState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.toIterationStateList(),
    volume = volume ?: 0.0,
    repetitions = repetitions ?: 0,
    intensity = intensity ?: 0.0
)