package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class UserWeightsDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("userId")
    val userId: String? = null,
    @SerialName("weight")
    val weight: Double? = null
)