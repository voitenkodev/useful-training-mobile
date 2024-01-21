package models

public data class Equipment(
    val id: String,
    val name: String,
    val type: EquipmentEnum,
    val status: EquipmentStatusEnum
)