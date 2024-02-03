package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleFiltersDto(
    @SerialName("categories")
    val categories: List<String>? = null,
    @SerialName("experiences")
    val experiences: List<String>? = null,
    @SerialName("forceTypes")
    val forceTypes: List<String>? = null,
    @SerialName("weightTypes")
    val weightTypes: List<String>? = null
)