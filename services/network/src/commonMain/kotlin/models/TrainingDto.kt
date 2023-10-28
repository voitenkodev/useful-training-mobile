package models

import kotlinx.serialization.Serializable

@Serializable
public data class TrainingDto(
    val id: String? = null,
    val exercises: List<ExerciseDto> = emptyList(),
    val duration: String?,
    val date: String?,
    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
)
