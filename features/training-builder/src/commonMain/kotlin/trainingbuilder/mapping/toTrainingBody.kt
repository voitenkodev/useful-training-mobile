package trainingbuilder.mapping

import trainingbuilder.state.Training

internal fun Training.toBody() = models.Training(
    id = id,
    exercises = exercises.map {
        models.Exercise(
            id = null,
            name = it.name,
            iterations = it.iterations.map {
                models.Iteration(
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