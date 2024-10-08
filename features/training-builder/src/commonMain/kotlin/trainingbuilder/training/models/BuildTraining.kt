package trainingbuilder.training.models

import DateTimeKtx
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class BuildTraining(
    val id: String? = null,
    val buildExercises: PersistentList<BuildExercise> = persistentListOf(),
    val startDateTime: Long = DateTimeKtx.todayMillis(),
    val duration: Long = 0,
    val volume: Double = 0.0,
    val repetitions: Int = 0,
    val intensity: Double = 0.0
)