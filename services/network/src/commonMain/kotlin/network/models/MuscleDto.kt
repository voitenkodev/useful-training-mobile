package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MuscleDto(
    @SerialName("id")
    val id: String? = null,
    @SerialName("muscleGroupId")
    val muscleGroupId: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("load")
    val load: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("createdAt")
    val createdAt: String? = null
)