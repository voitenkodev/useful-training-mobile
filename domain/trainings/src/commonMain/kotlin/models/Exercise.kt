package models

public data class Exercise(
    val id: String?,
    val name: String,
    val iterations: List<Iteration> = emptyList(),
    val volume: Double,
    val repetitions: Int,
    val intensity: Double
)