package exerciseexample.main.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
internal data class ExerciseExampleAchievements(
    val lastVolumes: ImmutableList<ExerciseVolume>,
    val maxRepetition: MaxRepetition,
    val maxVolume: ExerciseVolume,
    val maxWeight: MaxWeight
)