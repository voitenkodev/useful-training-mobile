package models

import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseDto(
    val id: String? = null,
    val name: String?,
    val iterations: List<IterationDto> = emptyList(),
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)