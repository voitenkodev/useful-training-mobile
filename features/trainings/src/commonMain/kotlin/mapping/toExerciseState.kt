package mapping

import training.Exercise

internal fun List<models.Exercise>.toExerciseStateList() = this.map { it.toExerciseState() }

internal fun models.Exercise.toExerciseState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.toIterationStateList(),
    tonnage = tonnage ?: 0.0,
    countOfLifting = countOfLifting ?: 0,
    intensity = intensity ?: 0.0
)