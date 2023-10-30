package traininig_exercise_iteration.models

public data class TrainingDao(
    val id: String? = null,
    val exercises: List<ExerciseDao> = emptyList(),
    val duration: Long?,
    val createdAt: String?,
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)