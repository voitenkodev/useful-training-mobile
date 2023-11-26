package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("muscleExerciseBundles")
    val muscleExerciseBundles: List<MuscleExerciseBundleDto> = emptyList(),
    @SerialName("name")
    val name: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("userId")
    val userId: String? = null,
    @SerialName("imageUrl")
    val imageUrl: String? = null
)