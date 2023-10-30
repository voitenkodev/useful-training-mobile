package exercise_example_muscle.models

public data class MuscleExerciseBundleDao(
    val id: String,
    val createdAt: String? = null,
    val exerciseExampleId: String? = null,
    val muscle: MuscleDao? = null,
    val muscleId: String? = null,
    val updatedAt: String? = null,
    val value: Int? = null
)