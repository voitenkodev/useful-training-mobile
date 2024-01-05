package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MaxRepetitionDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("exerciseExampleId")
    val exerciseExampleId: String? = null,
    @SerialName("exerciseId")
    val exerciseId: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("repetition")
    val repetition: Int? = null
)