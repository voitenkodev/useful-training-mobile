package models

public data class Exercise(
    val id: String? = null,
    val name: String?,
    val iterations: List<Iteration> = emptyList(),
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)