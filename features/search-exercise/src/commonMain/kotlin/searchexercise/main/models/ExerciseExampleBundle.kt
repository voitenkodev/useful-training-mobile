package searchexercise.main.models

import androidx.compose.runtime.Immutable
import muscles.Muscle

@Immutable
internal data class ExerciseExampleBundle(
    val id: String,
    val muscle: Muscle,
    val percentage: Int
)