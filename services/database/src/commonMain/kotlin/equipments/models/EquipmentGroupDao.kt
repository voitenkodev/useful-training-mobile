package equipments.models

public data class EquipmentGroupDao(
    val id: String,
    val name: String,
    val createdAt: String,
    val type: String,
    val updatedAt: String,
    val equipments: List<EquipmentDao>
)