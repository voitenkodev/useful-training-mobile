package models

public data class ExerciseExample(
    val id: String,
    val exerciseExampleBundles: List<ExerciseExampleBundle> = emptyList(),
    val name: String,
    val description: String?,
    val imageUrl: String?
)