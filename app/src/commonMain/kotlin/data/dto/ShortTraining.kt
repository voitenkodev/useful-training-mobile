package data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ShortTraining(
    @Transient
    val id: String? = null,
    val exercises: List<String> = emptyList(),
    val duration: String? = null,
    val date: String? = null,
)