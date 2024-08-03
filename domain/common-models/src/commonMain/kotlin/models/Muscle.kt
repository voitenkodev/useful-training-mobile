package models

public data class Muscle(
    val id: String,
    val name: String,
    val load: MuscleLoadEnum,
    val status: MuscleStatusEnum,
    val type: MuscleEnum
)