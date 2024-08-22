package trainingbuilder.training.pages.exercise

import androidx.compose.runtime.Immutable
import trainingbuilder.training.models.BuildExercise
import trainingbuilder.training.models.IterationTargetFocus

@Immutable
internal data class SetExerciseState(
    val buildExercise: BuildExercise,
    val focusTarget: Pair<Int, IterationTargetFocus> = -1 to IterationTargetFocus.Weight
)