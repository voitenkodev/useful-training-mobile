package exercise_example_muscle.models

public data class ExerciseExampleDao(
    val id: String,
    val muscleExerciseBundles: List<MuscleExerciseBundleDao> = emptyList(),
    val name: String,
    val createdAt: String,
    val updatedAt: String,
)