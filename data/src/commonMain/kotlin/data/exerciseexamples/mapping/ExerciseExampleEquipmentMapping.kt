package data.exerciseexamples.mapping

import data.equipments.mapping.dtoToDao
import exercise_examples.models.ExerciseExampleEquipmentDao
import network.models.ExerciseExampleEquipmentRefDto

internal fun List<ExerciseExampleEquipmentRefDto>.dtoToDao(): List<ExerciseExampleEquipmentDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun ExerciseExampleEquipmentRefDto.dtoToDao(): ExerciseExampleEquipmentDao? {
    return ExerciseExampleEquipmentDao(
        id = id ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null,
        equipmentId = equipmentId ?: return null,
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        equipment = equipment?.dtoToDao() ?: return null
    )
}