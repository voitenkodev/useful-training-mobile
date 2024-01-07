package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EquipmentGroupDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("nameUa")
    val nameUa: String? = null,
    @SerialName("nameRu")
    val nameRu: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("equipments")
    val equipments: List<EquipmentDto>? = null
)