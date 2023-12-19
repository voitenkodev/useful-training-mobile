package models

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
    @SerialName("height")
    val height: Double? = null
)