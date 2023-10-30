package models

public data class ExerciseExample(
    val id: String? = null,
    val muscleExerciseBundles: List<MuscleExerciseBundle> = emptyList(),
    val name: String
)