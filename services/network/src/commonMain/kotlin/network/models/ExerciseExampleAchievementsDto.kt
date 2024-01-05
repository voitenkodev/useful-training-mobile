package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseExampleAchievementsDto(
    @SerialName("lastVolumes")
    val lastVolumes: List<ExerciseVolumeDto>? = null,
    @SerialName("maxRepetition")
    val maxRepetition: MaxRepetitionDto? = null,
    @SerialName("maxVolume")
    val maxVolume: ExerciseVolumeDto? = null,
    @SerialName("maxWeight")
    val maxWeight: MaxWeightDto? = null
)