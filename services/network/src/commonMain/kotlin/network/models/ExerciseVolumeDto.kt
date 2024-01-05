package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseVolumeDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("exerciseExampleId")
    val exerciseExampleId: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("volume")
    val volume: Int? = null
)