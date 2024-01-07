package exerciseexample.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class ExerciseExampleBundle(
    val id: String,
    val muscle: Muscle,
    val percentage: Int
)