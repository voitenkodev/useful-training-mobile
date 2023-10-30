package exercise_example_muscle.models

public data class ExerciseDao(
    val id: String,
    val countOfLifting: Int? = null,
    val createdAt: String? = null,
    val intensity: Double? = null,
    val iterations: List<IterationDao> = emptyList(),
    val name: String? = null,
    val tonnage: Double? = null,
    val trainingId: String? = null,
    val updatedAt: String? = null
)