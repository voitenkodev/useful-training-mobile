package trainings.state

import DateTimeKtx
import androidx.compose.runtime.Immutable

@Immutable
internal data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = emptyList(),
    val startDateTime: String = DateTimeKtx.currentDateTime(),
    val duration: String,
    val tonnage: Double? = null,
    val intensity: Double? = null
)