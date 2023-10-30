package models

public data class Training(
    val id: String?,
    val exercises: List<Exercise> = emptyList(),
    val duration: Long,
    val createdAt: String?,
    val tonnage: Double,
    val countOfLifting: Int,
    val intensity: Double
)