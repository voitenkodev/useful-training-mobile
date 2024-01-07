package equipments.models

public data class EquipmentDao(
    val id: String,
    val name: String,
    val muscleTypeId: String,
    val type: String,
    val createdAt: String,
    val updatedAt: String,
    val status: String?
)