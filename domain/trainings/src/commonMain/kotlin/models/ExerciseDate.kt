package models

data class ExerciseDate(
    val trainingId: String? = null,
    val exercise: Exercise,
    val date: String,
)