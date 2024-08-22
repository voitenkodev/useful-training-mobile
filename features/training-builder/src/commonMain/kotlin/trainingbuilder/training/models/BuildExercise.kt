package trainingbuilder.training.models

import androidx.compose.runtime.Immutable
import exercise.ExerciseExample
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class BuildExercise(
    val id: String? = null,
    val name: String = "",
    val buildIterations: PersistentList<BuildIteration> = persistentListOf(),
    val exerciseExample: ExerciseExample? = null,
    val volume: Double = 0.0,
    val repetitions: Int = 0,
    val intensity: Double = 0.0
)