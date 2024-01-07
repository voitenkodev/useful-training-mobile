package models

public data class Muscle(
    val id: String,
    val name: String,
    val status: MuscleStatusEnum,
    val type: MuscleEnum
)