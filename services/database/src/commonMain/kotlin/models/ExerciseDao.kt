package models

public data class ExerciseDao(
    val id: String? = null,
    val name: String?,
    val iterations: List<IterationDao> = emptyList(),
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)