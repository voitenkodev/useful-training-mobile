package data.mapping

import data.dto.ExerciseDTO
import presentation.training.Exercise

internal fun List<ExerciseDTO>.toExerciseStateList() = this.map { it.toExerciseState() }

internal fun ExerciseDTO.toExerciseState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.toIterationStateList(),
    tonnage = tonnage ?: 0.0,
    countOfLifting = countOfLifting ?: 0,
    intensity = intensity ?: 0.0
)