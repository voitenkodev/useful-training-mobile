package trainingbuilder.builder.mapping

import trainingbuilder.builder.state.Training

internal fun Training.toBody(): models.Training {
    return models.Training(
        id = id,
        exercises = exercises.map {
            models.Exercise(
                id = null,
                name = it.name,
                iterations = it.iterations.mapNotNull {
                    models.Iteration(
                        id = null,
                        weight = it.weight.toDoubleOrNull() ?: return@mapNotNull null,
                        repetitions = it.repetitions.toIntOrNull() ?: return@mapNotNull null
                    )
                },
                volume = it.volume,
                repetitions = it.repetitions,
                intensity = it.intensity
            )
        },
        duration = duration,
        createdAt = startDateTime,
        volume = volume,
        repetitions = repetitions,
        intensity = intensity
    )
}