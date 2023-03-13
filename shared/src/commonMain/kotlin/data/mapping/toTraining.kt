package data.mapping

import data.dto.TrainingBody
import presentation.training.Training

internal fun Training.toBody() = TrainingBody(
    id = id,
    exercises = exercises.map {
        TrainingBody.Exercise(
            id = it.id,
            name = it.name,
            iterations = it.iterations.map {
                TrainingBody.Exercise.Iteration(
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