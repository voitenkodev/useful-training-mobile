package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDTO(
    @SerialName("token")
    val token: String? = null,
)