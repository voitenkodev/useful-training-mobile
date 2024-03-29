package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RegisterDto(
    @SerialName("email")
    val email: String? = null,
    @SerialName("password")
    val password: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("weight")
    val weight: Double? = null,
    @SerialName("experience")
    val experience: String? = null,
    @SerialName("height")
    val height: Double? = null,
    @SerialName("excludeMuscleIds")
    val excludeMuscleIds: List<String>? = null,
    @SerialName("excludeEquipmentIds")
    val excludeEquipmentIds: List<String>? = null
)