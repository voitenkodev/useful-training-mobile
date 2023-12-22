package models

public data class Muscle(
    val id: String,
    val name: String,
    val priority: PriorityEnum,
    val type: MuscleEnum
)