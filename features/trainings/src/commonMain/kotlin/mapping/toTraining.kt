package mapping

import models.Exercise
import models.Iteration
import training.Training

internal fun Training.toBody() = models.Training(
    id = id,
    exercises = exercises.map {
        Exercise(
            id = null,
            name = it.name,
            iterations = it.iterations.map {
                Iteration(
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