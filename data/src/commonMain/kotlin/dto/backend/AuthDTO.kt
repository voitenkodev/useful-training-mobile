package dto.backend

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthDTO(
    @SerialName("email")
    val email: String? = null,
    @SerialName("password")
    val password: String? = null
)