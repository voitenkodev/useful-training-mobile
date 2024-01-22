package exercise_examples.models

import equipments.models.EquipmentDao

public data class ExerciseExampleEquipmentDao(
    val id: String,
    val exerciseExampleId: String,
    val equipmentId: String,
    val equipment: EquipmentDao,
    val createdAt: String,
    val updatedAt: String
)