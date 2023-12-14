package trainingbuilder.training_builder.pages.set_iteration

import trainingbuilder.training_builder.models.Iteration
import trainingbuilder.training_builder.models.IterationTargetFocus

internal data class SetIterationState(
    val iterationIndex: Int,
    val iteration: Iteration,
    val targetFocus: IterationTargetFocus
)