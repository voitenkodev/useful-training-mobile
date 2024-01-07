package muscles.models

public data class MuscleTypeDao(
    val id: String,
    val name: String,
    val createdAt: String,
    val type: String,
    val updatedAt: String,
    val muscles: List<MuscleDao>
)