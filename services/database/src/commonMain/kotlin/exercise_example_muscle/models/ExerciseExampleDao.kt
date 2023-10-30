package exercise_example_muscle.models

public data class ExerciseExampleDao(
    val id: String,
    val muscleExerciseBundles: List<MuscleExerciseBundleDao> = emptyList(),
    val name: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)