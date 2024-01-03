package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class IterationDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("exerciseId")
    val exerciseId: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("repetitions")
    val repetitions: Int? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("weight")
    val weight: Double? = null
)