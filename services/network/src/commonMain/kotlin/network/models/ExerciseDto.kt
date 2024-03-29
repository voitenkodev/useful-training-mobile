package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseDto(
    @SerialName("repetitions")
    val repetitions: Int? = null,
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
    @SerialName("volume")
    val volume: Double? = null,
    @SerialName("trainingId")
    val trainingId: String? = null,
    @SerialName("exerciseExampleId")
    val exerciseExampleId: String? = null,
    @SerialName("exerciseExample")
    val exerciseExample: ExerciseExampleDto? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null
)