package data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class AuthBody(
    @SerialName("email")
    val email: String? = null,
    @SerialName("password")
    val password: String? = null
)