package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TutorialDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("exerciseExampleId")
    val exerciseExampleId: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("resource")
    val resource: String? = null,
    @SerialName("resourceType")
    val resourceType: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null
)