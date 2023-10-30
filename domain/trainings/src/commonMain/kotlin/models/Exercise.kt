package models

public data class Exercise(
    val id: String?,
    val name: String,
    val iterations: List<Iteration> = emptyList(),
    val tonnage: Double,
    val countOfLifting: Int,
    val intensity: Double
)