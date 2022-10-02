package data.mapping

import data.dto.ShortTraining
import presentation.state.ShortTrainingState

fun List<ShortTraining>.toShortTrainingState() = map {
    it.toShortTrainingState()
}

fun ShortTraining.toShortTrainingState() = ShortTrainingState(
    id = id,
    exercises = exercises,
    startDateTime = date ?: "",
    duration = duration,
)