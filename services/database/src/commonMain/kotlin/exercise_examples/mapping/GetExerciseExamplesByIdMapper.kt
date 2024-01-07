package exercise_examples.mapping

import data.GetExerciseExamplesById
import exercise_examples.models.ExerciseExampleBundleDao
import exercise_examples.models.ExerciseExampleDao
import muscles.models.MuscleDao

internal fun List<GetExerciseExamplesById>.mapToDao(): ExerciseExampleDao? {
    if (isEmpty()) return null

    val root = firstOrNull() ?: return null

    val bundles = groupBy { it.bundleId }.mapNotNull mapBundles@{ bundles ->

        val bundle = bundles.value.firstOrNull() ?: return@mapBundles null

        val muscle = MuscleDao(
            id = bundle.muscleId ?: return@mapBundles null,
            name = bundle.muscleName ?: return@mapBundles null,
            type = bundle.muscleType ?: return@mapBundles null,
            createdAt = bundle.muscleCreatedAt ?: return@mapBundles null,
            updatedAt = bundle.muscleUpdatedAt ?: return@mapBundles null,
            muscleGroupId = bundle.muscleMuscleGroupId ?: return@mapBundles null,
            status = bundle.muscleStatus
        )

        ExerciseExampleBundleDao(
            createdAt = bundle.bundleCreatedAt ?: return@mapBundles null,
            updatedAt = bundle.bundleUpdatedAt ?: return@mapBundles null,
            exerciseExampleId = bundle.id,
            id = bundle.bundleId ?: return@mapBundles null,
            muscleId = bundle.muscleId,
            percentage = bundle.bundlePercentage?.toInt() ?: return@mapBundles null,
            muscle = muscle
        )
    }

    return ExerciseExampleDao(
        id = root.id,
        name = root.name,
        description = root.description,
        createdAt = root.createdAt,
        updatedAt = root.updatedAt,
        imageUrl = root.imageUrl,
        exerciseExampleBundles = bundles
    )
}