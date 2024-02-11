package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleCriteriaBody(
    @SerialName("exerciseCount")
    val exerciseCount: Int? = null,
    @SerialName("exerciseExampleIds")
    val exerciseExampleIds: List<String?>? = null,
    @SerialName("targetMuscleId")
    val targetMuscleId: String? = null
)