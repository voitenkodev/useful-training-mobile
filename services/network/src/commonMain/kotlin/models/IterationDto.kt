package models

import kotlinx.serialization.Serializable

@Serializable
public data class IterationDto(
    val id: String? = null,
    val weight: Double?,
    val repeat: Int?
)