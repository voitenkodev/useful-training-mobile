package models

public data class MuscleGroup(
    val id: String,
    val name: String,
    val muscles: List<Muscle>,
    val type: MuscleGroupEnum
)