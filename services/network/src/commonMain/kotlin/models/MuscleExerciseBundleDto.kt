package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MuscleExerciseBundleDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("exerciseExampleId")
    val exerciseExampleId: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("muscle")
    val muscle: MuscleDto? = null,
    @SerialName("muscleId")
    val muscleId: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("percentage")
    val percentage: Int? = null
)