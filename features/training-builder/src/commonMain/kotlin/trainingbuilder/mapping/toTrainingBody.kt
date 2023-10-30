package trainingbuilder.mapping

import trainingbuilder.state.Training

internal fun Training.toBody() = models.Training(
    id = id,
    exercises = exercises.map {
        models.Exercise(
            id = null,
            name = it.name,
            iterations = it.iterations.mapNotNull {
                models.Iteration(
                    id = null,
                    weight = it.weight.toDoubleOrNull() ?: return@mapNotNull null,
                    repeat = it.repeat.toIntOrNull() ?: return@mapNotNull null
                )
            },
            tonnage = it.tonnage,
            countOfLifting = it.countOfLifting,
            intensity = it.intensity
        )
    },
    duration = duration,
    createdAt = startDateTime,
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity,
)