package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AuthResponse(
    @SerialName("token")
    val token: String? = null,
)