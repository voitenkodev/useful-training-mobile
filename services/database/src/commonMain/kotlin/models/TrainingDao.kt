package models

public data class TrainingDao(
    val id: String? = null,
    val exercises: List<ExerciseDao> = emptyList(),
    val duration: String?,
    val date: String?,
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)