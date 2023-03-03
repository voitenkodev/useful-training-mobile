package data.dto

import kotlinx.serialization.Serializable

@Serializable
internal class UserDto(
    val uid: String? = null,
    val displayName: String? = null,
    val email: String? = null
)