package exercise_examples.models

public data class ExerciseExampleDao(
    val id: String,
    val exerciseExampleBundles: List<ExerciseExampleBundleDao>,
    val name: String,
    val description: String?,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String?
)