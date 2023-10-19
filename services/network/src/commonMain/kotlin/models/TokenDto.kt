package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenDto(
    @SerialName("token")
    val token: String? = null,
)