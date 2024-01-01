package exercise_example_muscle.mapping

import data.GetExerciseExamplesById
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleDao
import exercise_example_muscle.models.MuscleExerciseBundleDao

internal fun List<GetExerciseExamplesById>.mapToDao(): ExerciseExampleDao? {
    if (isEmpty()) return null

    val root = firstOrNull() ?: return null

    val bundles = groupBy { it.muscleExerciseBundleId }.mapNotNull mapBundles@{ bundles ->

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

    return ExerciseExampleDao(
        id = root.id,
        name = root.name,
        description = root.description ?: return null,
        createdAt = root.createdAt,
        updatedAt = root.updatedAt,
        imageUrl = root.imageUrl,
        muscleExerciseBundles = bundles
    )
}