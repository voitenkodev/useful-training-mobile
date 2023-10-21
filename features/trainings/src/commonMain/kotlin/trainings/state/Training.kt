package trainings.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class Training(
    val id: String? = null,
    val exercises: ImmutableList<Exercise> = persistentListOf(),
    val dateIso: String,
    val startDate: String,
    val duration: String,
    val tonnage: String,
    val intensity: String,

    val tonnageExerciseList: ImmutableList<Float>
)