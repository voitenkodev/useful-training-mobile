package trainingbuilder.training_builder.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class ExerciseExample(
    val id: String,
    val name: String = "",
    val description: String = "",
    val imageUrl: String?,
    val muscleExerciseBundles: ImmutableList<MuscleExerciseBundle> = persistentListOf()
)