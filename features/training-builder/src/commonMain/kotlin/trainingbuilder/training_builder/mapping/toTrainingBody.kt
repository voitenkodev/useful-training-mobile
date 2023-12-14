package trainingbuilder.training_builder.mapping

import models.ExerciseExample
import trainingbuilder.training_builder.models.Training

internal fun Training.toBody(): models.Training {
    return models.Training(
        id = id,
        exercises = exercises.map {
            models.Exercise(
                id = null,
                name = it.name,
                iterations = it.iterations.mapNotNull { iteration ->
                    models.Iteration(
                        id = null,
                        weight = iteration.weight.toDoubleOrNull() ?: return@mapNotNull null,
                        repetitions = iteration.repetitions.toIntOrNull() ?: return@mapNotNull null
                    )
                },
                volume = it.volume,
                repetitions = it.repetitions,
                intensity = it.intensity,
                exerciseExample = it.exerciseExample?.let { ex ->
                    ExerciseExample(
                        id = ex.id,
                        name = ex.name,
                        imageUrl = ex.imageUrl
                    )
                }
            )
        },
        duration = duration,
        createdAt = startDateTime,
        volume = volume,
        repetitions = repetitions,
        intensity = intensity
    )
}