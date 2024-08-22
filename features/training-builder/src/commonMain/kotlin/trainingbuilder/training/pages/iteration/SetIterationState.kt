package trainingbuilder.training.pages.iteration

import trainingbuilder.training.models.BuildIteration
import trainingbuilder.training.models.IterationTargetFocus

internal data class SetIterationState(
    val iterationIndex: Int,
    val buildIteration: BuildIteration,
    val targetFocus: IterationTargetFocus
)