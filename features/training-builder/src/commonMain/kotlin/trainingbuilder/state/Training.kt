package trainingbuilder.state

import DateTimeKtx
import androidx.compose.runtime.Immutable

@Immutable
internal data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = listOf(Exercise()),
    val startDateTime: String = DateTimeKtx.currentDateTime(),
    val duration: Long = 0,
    val volume: Double = 0.0,
    val repetitions: Int = 0,
    val intensity: Double = 0.0
)