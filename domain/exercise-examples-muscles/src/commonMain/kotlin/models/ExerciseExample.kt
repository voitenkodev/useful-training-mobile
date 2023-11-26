package models

public data class ExerciseExample(
    val id: String?,
    val muscleExerciseBundles: List<MuscleExerciseBundle> = emptyList(),
    val name: String,
    val imageUrl: String?
)