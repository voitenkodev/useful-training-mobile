package traininig_exercise_iteration.models

public data class ExerciseDao(
    val id: String,
    val countOfLifting: Int,
    val createdAt: String,
    val intensity: Double,
    val iterations: List<IterationDao> = emptyList(),
    val name: String,
    val volume: Double,
    val trainingId: String,
    val updatedAt: String
)