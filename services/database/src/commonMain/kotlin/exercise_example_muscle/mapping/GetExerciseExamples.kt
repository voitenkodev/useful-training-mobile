package exercise_example_muscle.mapping

import data.GetExerciseExamples
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleDao
import exercise_example_muscle.models.MuscleExerciseBundleDao

internal fun List<GetExerciseExamples>.mapToDao(): List<ExerciseExampleDao> {
    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull { ex ->

        val root = ex.value.firstOrNull() ?: return@mapNotNull null

        val bundles = ex.value.groupBy { it.muscleExerciseBundleId }.mapNotNull mapBundles@{ bundles ->

            val bundle = bundles.value.firstOrNull() ?: return@mapBundles null

            val muscle = MuscleDao(
                id = bundle.muscleId ?: return@mapBundles null,
                name = bundle.muscleName ?: return@mapBundles null,
                type = bundle.muscleType ?: return@mapBundles null,
                createdAt = bundle.muscleCreatedAt ?: return@mapBundles null,
                updatedAt = bundle.muscleUpdatedAt ?: return@mapBundles null,
                muscleTypeId = bundle.muscleMuscleTypeId ?: return@mapBundles null,
                status = bundle.muscleStatus ?: return@mapBundles null
            )

            MuscleExerciseBundleDao(
                createdAt = bundle.muscleExerciseBundleCreatedAt ?: return@mapBundles null,
                updatedAt = bundle.muscleExerciseBundleUpdatedAt ?: return@mapBundles null,
                exerciseExampleId = bundle.id,
                id = bundle.muscleExerciseBundleId ?: return@mapBundles null,
                muscleId = bundle.muscleId,
                percentage = bundle.muscleExerciseBundlePercentage?.toInt() ?: return@mapBundles null,
                muscle = muscle
            )
        }

        ExerciseExampleDao(
            id = root.id,
            name = root.name ?: return@mapNotNull null,
            description = root.description ?: return@mapNotNull null,
            createdAt = root.createdAt ?: return@mapNotNull null,
            updatedAt = root.updatedAt ?: return@mapNotNull null,
            imageUrl = root.imageUrl,
            muscleExerciseBundles = bundles
        )
    }
}