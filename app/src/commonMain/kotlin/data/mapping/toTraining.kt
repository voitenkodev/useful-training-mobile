package data.mapping

import data.dto.Training
import redux.TrainingState

fun TrainingState.toTraining() = Training(
    id = id,
    exercises = exercises.map {
        Training.Exercise(
            id = it.id,
            name = it.name,
            iterations = it.iterations.map {
                Training.Exercise.Iteration(
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