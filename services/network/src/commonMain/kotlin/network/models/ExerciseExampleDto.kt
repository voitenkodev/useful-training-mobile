package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleDto(
    @SerialName("createdAt")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("exerciseExampleBundles")
    val exerciseExampleBundles: List<ExerciseExampleBundleDto> = emptyList(),
    @SerialName("name")
    val name: String? = null,
    @SerialName("forceType")
    val forceType: String? = null,
    @SerialName("weightType")
    val weightType: String? = null,
    @SerialName("category")
    val category: String? = null,
    @SerialName("experience")
    val experience: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("userId")
    val userId: String? = null,
    @SerialName("imageUrl")
    val imageUrl: String? = null,
    @SerialName("equipmentRefs")
    val equipmentRefs: List<ExerciseExampleEquipmentRefDto> = emptyList()
)
