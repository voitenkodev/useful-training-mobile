package muscles.models

public data class MuscleGroupDao(
    val id: String,
    val name: String,
    val createdAt: String,
    val type: String,
    val updatedAt: String,
    val muscles: List<MuscleDao>
)