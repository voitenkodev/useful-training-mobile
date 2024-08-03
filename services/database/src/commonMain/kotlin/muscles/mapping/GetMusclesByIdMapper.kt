package muscles.mapping

import data.GetMusclesById
import muscles.models.MuscleDao

internal fun GetMusclesById.mapToDao(): MuscleDao {
    return MuscleDao(
        id = id,
        name = name,
        type = type,
        muscleGroupId = muscleGroupId,
        createdAt = createdAt,
        updatedAt = updatedAt,
        status = status,
        load = load,
    )
}