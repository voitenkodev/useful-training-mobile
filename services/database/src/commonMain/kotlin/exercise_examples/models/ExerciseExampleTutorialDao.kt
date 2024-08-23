package exercise_examples.models

public data class ExerciseExampleTutorialDao(
    val id: String,
    val exerciseExampleId: String,
    val title: String,
    val value: String,
    val language: String,
    val author: String?,
    val resourceType: String,
    val createdAt: String,
    val updatedAt: String
)