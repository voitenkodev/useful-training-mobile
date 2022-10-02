package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ShortTraining(
    val id: String? = null,
    val exercises: List<String> = emptyList(),
    val duration: String? = null,
    val date: String? = null,
)