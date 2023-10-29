package models

public data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = emptyList(),
    val duration: Long?,
    val date: String?,
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)