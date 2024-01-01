package exercise_example_muscle.models

public data class MuscleDao(
    val id: String,
    val name: String,
    val muscleTypeId: String,
    val type: String,
    val createdAt: String,
    val updatedAt: String,
    val status: String?,
)