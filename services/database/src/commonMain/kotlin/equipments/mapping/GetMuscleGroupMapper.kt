package equipments.mapping

import data.GetMuscleGroups
import equipments.models.EquipmentDao
import equipments.models.EquipmentTypeDao

internal fun List<GetMuscleGroups>.mapToDao(): List<EquipmentTypeDao> {
    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull mapMuscleGroups@{ mt ->

        val root = mt.value.firstOrNull() ?: return@mapMuscleGroups null

        val muscles = mt.value.groupBy { it.muscleId }.mapNotNull mapMuscles@{ m ->

            val groups = m.value.firstOrNull() ?: return@mapMuscles null

            EquipmentDao(
                createdAt = groups.muscleCreatedAt ?: return@mapMuscles null,
                updatedAt = groups.muscleUpdatedAt ?: return@mapMuscles null,
                equipmentGroupId = groups.id,
                id = groups.muscleId ?: return@mapMuscles null,
                name = groups.muscleName ?: return@mapMuscles null,
                type = groups.muscleType ?: return@mapMuscles null,
                status = groups.muscleStatus
            )
        }

        EquipmentTypeDao(
            createdAt = root.createdAt,
            updatedAt = root.updatedAt,
            name = root.name,
            type = root.type,
            id = root.id,
            muscles = muscles
        )
    }
}