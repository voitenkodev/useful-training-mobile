package trainingbuilder.training_builder.mapping

import models.CategoryEnum
import models.ExerciseExample
import models.ExperienceEnum
import models.ForceTypeEnum
import models.WeightTypeEnum
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
                        description = ex.description,
                        imageUrl = ex.imageUrl,
                        weightType = WeightTypeEnum.FIXED, // todo do not need it in body
                        category = CategoryEnum.COMPOUND, // todo do not need it in body
                        forceType = ForceTypeEnum.PULL, // todo do not need it in body
                        experience = ExperienceEnum.BEGINNER, // todo do not need it in body
                        equipments = emptyList(), // todo do not need it in body
                        tutorials = emptyList(), // todo do not need it in body
                        exerciseExampleBundles = emptyList() // todo do not need it in body
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