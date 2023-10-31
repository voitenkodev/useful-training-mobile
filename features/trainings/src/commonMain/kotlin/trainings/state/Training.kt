package trainings.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class Training(
    val id: String,
    val exercises: ImmutableList<Exercise> = persistentListOf(),
    val tonnageExerciseList: ImmutableList<Float>,
    val dateIso: String,
    val startDate: String,
    val duration: Long,
    val tonnage: String,
    val intensity: String
)