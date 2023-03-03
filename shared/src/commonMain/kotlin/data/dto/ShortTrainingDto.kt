package data.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class ShortTrainingDto(
    val id: String? = null,
    val exercises: List<String> = emptyList(),
    val duration: String? = null,
    val date: String? = null,
)