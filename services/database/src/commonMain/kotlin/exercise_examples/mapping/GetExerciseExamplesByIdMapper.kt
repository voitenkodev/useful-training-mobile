package exercise_examples.mapping

import data.GetExerciseExamplesById
import equipments.models.EquipmentDao
import exercise_examples.models.ExerciseExampleBundleDao
import exercise_examples.models.ExerciseExampleDao
import exercise_examples.models.ExerciseExampleEquipmentDao
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

    val equipments = groupBy { it.equipmentRefId }.mapNotNull mapEquip@{ item ->

        val value = item.value.firstOrNull() ?: return@mapEquip null

        val equipment = EquipmentDao(
            createdAt = value.equipmentCreatedAt ?: return@mapEquip null,
            updatedAt = value.equipmentUpdatedAt ?: return@mapEquip null,
            id = value.equipmentId ?: return@mapEquip null,
            type = value.equipmentType ?: return@mapEquip null,
            name = value.equipmentName ?: return@mapEquip null,
            equipmentGroupId = value.equipmentEquipmentGroupId ?: return@mapEquip null,
            status = value.equipmentStatus
        )

        return@mapEquip ExerciseExampleEquipmentDao(
            id = value.equipmentRefId ?: return@mapEquip null,
            equipmentId = value.equipmentRefEquipmentId ?: return@mapEquip null,
            exerciseExampleId = value.equipmentRefExerciseExampleId ?: return@mapEquip null,
            equipment = equipment,
            createdAt = value.equipmentRefCreatedAt ?: return@mapEquip null,
            updatedAt = value.equipmentRefUpdatedAt ?: return@mapEquip null
        )
    }

    return ExerciseExampleDao(
        id = root.id,
        name = root.name,
        description = root.description,
        createdAt = root.createdAt,
        updatedAt = root.updatedAt,
        imageUrl = root.imageUrl,
        exerciseExampleBundles = bundles,
        equipments = equipments
    )
}