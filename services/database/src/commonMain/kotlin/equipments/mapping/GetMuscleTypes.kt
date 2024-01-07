package equipments.mapping

import data.GetMuscleTypes
import equipments.models.EquipmentDao
import equipments.models.EquipmentTypeDao

internal fun List<GetMuscleTypes>.mapToDao(): List<EquipmentTypeDao> {
    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull mapMuscleTypes@{ mt ->

        val root = mt.value.firstOrNull() ?: return@mapMuscleTypes null

        val muscles = mt.value.groupBy { it.muscleId }.mapNotNull mapMuscles@{ m ->

            val getMuscleTypes = m.value.firstOrNull() ?: return@mapMuscles null

            EquipmentDao(
                createdAt = getMuscleTypes.muscleCreatedAt ?: return@mapMuscles null,
                updatedAt = getMuscleTypes.muscleUpdatedAt ?: return@mapMuscles null,
                muscleTypeId = getMuscleTypes.id,
                id = getMuscleTypes.muscleId ?: return@mapMuscles null,
                name = getMuscleTypes.muscleName ?: return@mapMuscles null,
                type = getMuscleTypes.muscleType ?: return@mapMuscles null,
                status = getMuscleTypes.muscleStatus
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