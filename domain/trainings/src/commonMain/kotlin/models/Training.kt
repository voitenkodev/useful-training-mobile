package models

public data class Training(
    val id: String?,
    val exercises: List<Exercise> = emptyList(),
    val duration: Long,
    val createdAt: String?,
    val volume: Double,
    val repetitions: Int,
    val intensity: Double
)