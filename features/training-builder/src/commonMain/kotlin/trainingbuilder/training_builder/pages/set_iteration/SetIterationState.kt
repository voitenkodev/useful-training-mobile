package trainingbuilder.training_builder.pages.set_iteration

import trainingbuilder.training_builder.models.BuildIteration
import trainingbuilder.training_builder.models.IterationTargetFocus

internal data class SetIterationState(
    val iterationIndex: Int,
    val buildIteration: BuildIteration,
    val targetFocus: IterationTargetFocus
)