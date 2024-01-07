package trainingbuilder.training_builder.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class ExerciseExampleBundle(
    val id: String? = null,
    val percentage: Int = 0,
    val muscle: Muscle
)