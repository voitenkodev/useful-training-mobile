package exercise_example_muscle.models

public data class ExerciseExampleDao(
    val id: String,
    val muscleExerciseBundles: List<MuscleExerciseBundleDao>,
    val name: String,
    val description: String,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String?
)