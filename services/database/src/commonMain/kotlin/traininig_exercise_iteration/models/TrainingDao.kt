package traininig_exercise_iteration.models

public data class TrainingDao(
    val id: String,
    val repetitions: Int,
    val createdAt: String,
    val duration: Long,
    val exercises: List<ExerciseDao>,
    val intensity: Double,
    val volume: Double,
    val updatedAt: String
)