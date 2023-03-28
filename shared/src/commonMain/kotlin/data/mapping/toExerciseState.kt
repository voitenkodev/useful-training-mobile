package data.mapping

import data.dto.ExerciseDTO
import presentation.training.Exercise
import presentation.training.Iteration

internal fun List<ExerciseDTO?>.toExerciseStateList() = this.mapNotNull { it?.toExerciseState() }

internal fun ExerciseDTO.toExerciseState() = Exercise(
    id = id ?: "",
    name = name ?: "",
    iterations = iterations.map {
        Iteration(
            weight = it.weight?.toDoubleOrIntString() ?: "",
            repeat = it.repeat?.toString() ?: ""
        )
    },
    tonnage = tonnage ?: 0.0,
    countOfLifting = countOfLifting ?: 0,
    intensity = intensity ?: 0.0
)