package exercise_examples.mapping

import data.GetExerciseExamples
import equipments.models.EquipmentDao
import exercise_examples.models.ExerciseExampleBundleDao
import exercise_examples.models.ExerciseExampleDao
import exercise_examples.models.ExerciseExampleEquipmentDao
import exercise_examples.models.ExerciseExampleTutorialDao
import muscles.models.MuscleDao

internal fun List<GetExerciseExamples>.mapToDao(): List<ExerciseExampleDao> {
    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull { ex ->

        val root = ex.value.firstOrNull() ?: return@mapNotNull null

        val bundles = ex.value.groupBy { it.bundleId }.mapNotNull mapBundles@{ bundles ->

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

        val tutorials = groupBy { it.tutorialId }.mapNotNull mapTutorial@{ item ->

            val value = item.value.firstOrNull() ?: return@mapTutorial null

            return@mapTutorial ExerciseExampleTutorialDao(
                id = value.tutorialId ?: return@mapTutorial null,
                title = value.tutorialTitle ?: return@mapTutorial null,
                language = value.tutorialLanguage ?: return@mapTutorial null,
                resource = value.tutorialResource ?: return@mapTutorial null,
                exerciseExampleId = value.tutorialExerciseExampleId ?: return@mapTutorial null,
                resourceType = value.tutorialResourceType ?: return@mapTutorial null,
                value = value.tutorialValue ?: return@mapTutorial null,
                createdAt = value.tutorialCreateAt ?: return@mapTutorial null,
                updatedAt = value.tutorialUpdateAt ?: return@mapTutorial null
            )
        }

        ExerciseExampleDao(
            id = root.id,
            name = root.name,
            description = root.description ?: return@mapNotNull null,
            createdAt = root.createdAt,
            updatedAt = root.updatedAt,
            imageUrl = root.imageUrl,
            exerciseExampleBundles = bundles,
            equipments = equipments,
            experience = root.experience,
            forceType = root.forceType,
            weightType = root.weightType,
            category = root.category,
            tutorials = tutorials
        )
    }
}