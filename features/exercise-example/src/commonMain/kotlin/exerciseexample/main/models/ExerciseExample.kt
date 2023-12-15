package exerciseexample.main.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
internal data class ExerciseExample(
    val id: String,
    val muscleExerciseBundles: ImmutableList<MuscleExerciseBundle>,
    val name: String,
    val imageUrl: String?
)