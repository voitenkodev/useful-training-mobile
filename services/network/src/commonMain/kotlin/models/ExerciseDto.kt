package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseDto(
    @SerialName("countOfLifting")
    val countOfLifting: Int? = null,
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("intensity")
    val intensity: Double? = null,
    @SerialName("iterations")
    val iterations: List<IterationDto> = emptyList(),
    @SerialName("name")
    val name: String? = null,
    @SerialName("tonnage")
    val tonnage: Double? = null,
    @SerialName("trainingId")
    val trainingId: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null
)