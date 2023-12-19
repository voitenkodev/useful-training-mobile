package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class UserDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("height")
    val height: Double? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("weight")
    val weight: Double? = null
)