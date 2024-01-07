package searchexercise.main.models

import androidx.compose.runtime.Immutable

@Immutable
public data class ExerciseExampleBundle(
    val id: String,
    val muscle: Muscle,
    val percentage: Int
)