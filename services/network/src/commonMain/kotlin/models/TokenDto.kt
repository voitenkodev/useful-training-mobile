package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDto(
    @SerialName("token")
    val token: String? = null,
)