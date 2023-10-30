package exercise_example_muscle.models

public data class IterationDao(
    val id: String,
    val createdAt: String? = null,
    val exerciseId: String? = null,
    val repeat: Int? = null,
    val updatedAt: String? = null,
    val weight: Double? = null
)