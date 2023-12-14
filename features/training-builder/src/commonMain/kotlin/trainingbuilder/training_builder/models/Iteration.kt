package trainingbuilder.training_builder.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class Iteration(
    val id: String? = null,
    val weight: String = "",
    val repetitions: String = ""
)