package trainingbuilder.training.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class BuildIteration(
    val id: String? = null,
    val weight: String = "",
    val repetitions: String = ""
)