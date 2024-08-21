package trainingbuilder.training_builder.models

import DateTimeKtx
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class Training(
    val id: String? = null,
    val exercises: PersistentList<Exercise> = persistentListOf(),
    val startDateTime: Long = DateTimeKtx.todayMillis(),
    val duration: Long = 0,
    val volume: Double = 0.0,
    val repetitions: Int = 0,
    val intensity: Double = 0.0
)