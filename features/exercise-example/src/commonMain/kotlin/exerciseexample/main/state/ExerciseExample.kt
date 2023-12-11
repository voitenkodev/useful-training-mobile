package exerciseexample.main.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
public data class ExerciseExample(
    val id: String,
    val muscleExerciseBundles: ImmutableList<MuscleExerciseBundle>,
    val name: String,
    val imageUrl: String?
)