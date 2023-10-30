package configurations.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class ExerciseExample(
    val id: String? = null,
    val name: String = "",
    val muscleBundles: ImmutableList<MuscleExerciseBundle> = persistentListOf()
)