package trainings.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = emptyList(),
    val dateIso: String,
    val startDate: String,
    val duration: String,
    val tonnage: Double? = null,
    val intensity: Double? = null
)