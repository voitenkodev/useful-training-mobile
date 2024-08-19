package trainings

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
public data class Training(
    val id: String,
    val exercises: ImmutableList<Exercise> = persistentListOf(),
    val volumeExerciseList: ImmutableList<Float>,
    val createdAt: String,
    val duration: Long,
    val volume: Double,
    val intensity: String
)