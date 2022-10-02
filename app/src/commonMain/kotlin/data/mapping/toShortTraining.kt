package data.mapping

import data.dto.ShortTraining
import data.dto.Training

fun Training.toShortTraining() = ShortTraining(
    id = id,
    exercises = exercises.mapNotNull { it.name },
    duration = duration,
    date = date,
)