package models

import kotlinx.serialization.Serializable

@Serializable
data class IterationDto(
    val id: String? = null,
    val weight: Double?,
    val repeat: Int?
)