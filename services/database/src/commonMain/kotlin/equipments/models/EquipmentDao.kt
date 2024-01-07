package equipments.models

public data class EquipmentDao(
    val id: String,
    val name: String,
    val equipmentGroupId: String,
    val type: String,
    val createdAt: String,
    val updatedAt: String,
    val status: String?
)