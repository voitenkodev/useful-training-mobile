package data.mapping

import data.dto.ExerciseDateDTO
import presentation.summary.ExerciseDate

internal fun List<ExerciseDateDTO?>.toExerciseDateStateList() = this.mapNotNull { it?.toExerciseDateState() }

internal fun ExerciseDateDTO.toExerciseDateState() = ExerciseDate(
    trainingId = trainingId,
    exercise = exercise?.toExerciseState(),
    date = date
)