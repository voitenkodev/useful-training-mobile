package traininig_exercise_iteration.models

public data class IterationDao(
    val id: String,
    val createdAt: String,
    val exerciseId: String,
    val repeat: Int,
    val updatedAt: String,
    val weight: Double
)