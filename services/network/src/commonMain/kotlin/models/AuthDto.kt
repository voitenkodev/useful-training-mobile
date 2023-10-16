package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthDto(
    @SerialName("email")
    val email: String? = null,
    @SerialName("password")
    val password: String? = null
)