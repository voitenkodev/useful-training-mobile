package models

public data class MuscleExerciseBundle(
    val id: String?,
    val muscleId: String,
    val muscle: Muscle?,
    val percentage: Int
)