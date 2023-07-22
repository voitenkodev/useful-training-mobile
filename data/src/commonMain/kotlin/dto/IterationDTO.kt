package dto

import kotlinx.serialization.Serializable

@Serializable
data class IterationDTO(
    val id: String? = null,
    val weight: Double?,
    val repeat: Int?
)