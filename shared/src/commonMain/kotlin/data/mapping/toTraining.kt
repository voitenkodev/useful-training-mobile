package data.mapping

import data.dto.TrainingDto
import presentation.training.Training

internal fun Training.toTraining() = TrainingDto(
    id = id,
    exercises = exercises.map {
        TrainingDto.Exercise(
            id = it.id,
            name = it.name,
            iterations = it.iterations.map {
                TrainingDto.Exercise.Iteration(
                    weight = it.weight.toDoubleOrNull(),
                    repeat = it.repeat.toIntOrNull()
                )
            },
            tonnage = it.tonnage,
            countOfLifting = it.countOfLifting,
            intensity = it.intensity
        )
    },
    duration = duration,
    date = startDateTime,
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity,
)