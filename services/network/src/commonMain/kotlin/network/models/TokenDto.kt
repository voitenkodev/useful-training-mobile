package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenDto(
    @SerialName("accessToken")
    val accessToken: String? = null,
    @SerialName("id")
    val id: String? = null
)