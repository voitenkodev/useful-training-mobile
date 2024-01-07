package muscles.models

public data class MuscleDao(
    val id: String,
    val name: String,
    val muscleGroupId: String,
    val type: String,
    val createdAt: String,
    val updatedAt: String,
    val status: String?
)