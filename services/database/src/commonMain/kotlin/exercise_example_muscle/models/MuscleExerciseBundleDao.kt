package exercise_example_muscle.models

public data class MuscleExerciseBundleDao(
    val id: String,
    val createdAt: String,
    val exerciseExampleId: String,
    val muscle: MuscleDao,
    val muscleId: String,
    val updatedAt: String,
    val value: Int
)