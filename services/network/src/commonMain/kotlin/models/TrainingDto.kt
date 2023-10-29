package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TrainingDto(
    @SerialName("countOfLifting")
    val countOfLifting: Int? = null,
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("duration")
    val duration: Long? = null,
    @SerialName("exercises")
    val exercises: List<ExerciseDto> = emptyList(),
    @SerialName("id")
    val id: String? = null,
    @SerialName("intensity")
    val intensity: Double? = null,
    @SerialName("tonnage")
    val tonnage: Double? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("userId")
    val userId: String? = null
)



