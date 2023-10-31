package traininig_exercise_iteration.models

public data class TrainingDao(
    val id: String,
    val countOfLifting: Int,
    val createdAt: String,
    val duration: Long,
    val exercises: List<ExerciseDao> = emptyList(),
    val intensity: Double,
    val tonnage: Double,
    val updatedAt: String
)