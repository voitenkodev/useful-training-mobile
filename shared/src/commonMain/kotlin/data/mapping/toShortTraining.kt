package data.mapping

import data.dto.ShortTrainingDto
import data.dto.TrainingDto

internal fun TrainingDto.toShortTraining() = ShortTrainingDto(
    id = id,
    exercises = exercises.mapNotNull { it.name },
    duration = duration,
    date = date,
)