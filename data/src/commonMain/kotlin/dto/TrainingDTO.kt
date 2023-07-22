package dto

import kotlinx.serialization.Serializable

@Serializable
data class TrainingDTO(
    val id: String? = null,
    val exercises: List<ExerciseDTO> = emptyList(),
    val duration: String?,
    val date: String?,
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)