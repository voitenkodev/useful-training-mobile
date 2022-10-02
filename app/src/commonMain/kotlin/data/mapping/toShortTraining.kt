package data.mapping

import data.dto.ShortTraining
import data.dto.Training
import presentation.state.TrainingState

fun TrainingState.toShortTraining() = ShortTraining(
    id = id,
    exercises = exercises.map { it.name },
    duration = duration,
    date = startDateTime,
)

fun Training.toShortTraining() = ShortTraining(
    id = id,
    exercises = exercises.mapNotNull { it.name },
    duration = duration,
    date = date,
)