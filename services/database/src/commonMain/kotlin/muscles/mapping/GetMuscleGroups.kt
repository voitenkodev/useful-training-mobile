package muscles.mapping

import data.GetMuscleGroups
import muscles.models.MuscleDao
import muscles.models.MuscleGroupDao

internal fun List<GetMuscleGroups>.mapToDao(): List<MuscleGroupDao> {
    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull mapMuscleTypes@{ mt ->

        val root = mt.value.firstOrNull() ?: return@mapMuscleTypes null

        val muscles = mt.value.groupBy { it.muscleId }.mapNotNull mapMuscles@{ m ->

            val getMuscleTypes = m.value.firstOrNull() ?: return@mapMuscles null

            MuscleDao(
                createdAt = getMuscleTypes.muscleCreatedAt ?: return@mapMuscles null,
                updatedAt = getMuscleTypes.muscleUpdatedAt ?: return@mapMuscles null,
                muscleGroupId = getMuscleTypes.id,
                id = getMuscleTypes.muscleId ?: return@mapMuscles null,
                name = getMuscleTypes.muscleName ?: return@mapMuscles null,
                type = getMuscleTypes.muscleType ?: return@mapMuscles null,
                status = getMuscleTypes.muscleStatus
            )
        }

        MuscleGroupDao(
            createdAt = root.createdAt,
            updatedAt = root.updatedAt,
            name = root.name,
            type = root.type,
            id = root.id,
            muscles = muscles
        )
    }
}