package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ExerciseDTO(
    val id: String? = null,
    val name: String?,
    val iterations: List<IterationDTO> = emptyList(),
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)