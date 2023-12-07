package trainingbuilder.builder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class Exercise(
    val id: String? = null,
    val name: String = "",
    val iterations: PersistentList<Iteration> = persistentListOf(),
    val exerciseExample: ExerciseExample? = null,
    val volume: Double = 0.0,
    val repetitions: Int = 0,
    val intensity: Double = 0.0
)