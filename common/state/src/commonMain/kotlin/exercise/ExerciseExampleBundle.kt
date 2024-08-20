package exercise

import androidx.compose.runtime.Immutable
import muscles.Muscle

@Immutable
public data class ExerciseExampleBundle(
    val id: String,
    val muscle: Muscle,
    val percentage: Int
)