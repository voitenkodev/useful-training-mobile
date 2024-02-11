package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleFiltersBody(
    @SerialName("category")
    val category: String? = null,
    @SerialName("equipmentIds")
    val equipmentIds: List<String?>? = null,
    @SerialName("experience")
    val experience: String? = null,
    @SerialName("forceType")
    val forceType: String? = null,
    @SerialName("muscleIds")
    val muscleIds: List<String?>? = null,
    @SerialName("query")
    val query: String? = null,
    @SerialName("weightType")
    val weightType: String? = null
)