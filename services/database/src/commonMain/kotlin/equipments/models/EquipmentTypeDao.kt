package equipments.models

public data class EquipmentTypeDao(
    val id: String,
    val name: String,
    val createdAt: String,
    val type: String,
    val updatedAt: String,
    val muscles: List<EquipmentDao>
)