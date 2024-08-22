package trainingbuilder.training.mapping

import DateTimeKtx
import models.CategoryEnum
import models.ExerciseExample
import models.ExperienceEnum
import models.ForceTypeEnum
import models.WeightTypeEnum
import trainingbuilder.training.models.BuildTraining

internal fun BuildTraining.toBody(): models.Training {
    return models.Training(
        id = id,
        exercises = buildExercises.map {
            models.Exercise(
                id = null,
                name = it.name,
                iterations = it.buildIterations.mapNotNull { iteration ->
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
                        weightType = WeightTypeEnum.FIXED, // do not need it in body
                        category = CategoryEnum.COMPOUND, // do not need it in body
                        forceType = ForceTypeEnum.PULL, // do not need it in body
                        experience = ExperienceEnum.BEGINNER, // do not need it in body
                        equipments = emptyList(), // do not need it in body
                        tutorials = emptyList(), // do not need it in body
                        exerciseExampleBundles = emptyList() // do not need it in body
                    )
                }
            )
        },
        duration = duration,
        createdAt = DateTimeKtx.millisToIso(startDateTime),
        volume = volume,
        repetitions = repetitions,
        intensity = intensity
    )
}