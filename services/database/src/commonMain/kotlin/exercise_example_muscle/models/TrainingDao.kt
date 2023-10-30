package exercise_example_muscle.models

public data class TrainingDao(
    val id: String,
    val countOfLifting: Int? = null,
    val createdAt: String? = null,
    val duration: Long? = null,
    val exercises: List<ExerciseDao> = emptyList(),
    val intensity: Double? = null,
    val tonnage: Double? = null,
    val updatedAt: String? = null,
    val userId: String? = null
)



