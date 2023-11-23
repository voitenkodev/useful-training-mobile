package trainingbuilder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class ExerciseExample(
    val id: String? = null,
    val name: String = "",
    val muscleExerciseBundles: PersistentList<MuscleExerciseBundle> = persistentListOf()
)