package models

public data class Equipment(
    val id: String,
    val name: String,
    val imageUrl: String,
    val status: EquipmentStatusEnum
)