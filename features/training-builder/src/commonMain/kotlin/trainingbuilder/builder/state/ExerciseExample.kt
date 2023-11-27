package trainingbuilder.builder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class ExerciseExample(
    val id: String? = null,
    val name: String = "",
    val imageUrl: String?,
    val muscleExerciseBundles: ImmutableList<MuscleExerciseBundle> = persistentListOf()
)