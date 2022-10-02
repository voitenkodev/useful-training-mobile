package data.dto

import kotlinx.serialization.Serializable

@Serializable
class User(
    val uid: String? = null,
    val displayName: String? = null,
    val email: String? = null
)