package exerciseexample.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class MuscleExerciseBundle(
    val id: String,
    val muscle: Muscle,
    val percentage: Int
)