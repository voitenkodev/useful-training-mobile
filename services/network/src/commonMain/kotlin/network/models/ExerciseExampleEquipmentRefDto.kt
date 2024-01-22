package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleEquipmentRefDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("equipment")
    val equipment: EquipmentDto? = null,
    @SerialName("equipmentId")
    val equipmentId: String? = null,
    @SerialName("exerciseExampleId")
    val exerciseExampleId: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null
)