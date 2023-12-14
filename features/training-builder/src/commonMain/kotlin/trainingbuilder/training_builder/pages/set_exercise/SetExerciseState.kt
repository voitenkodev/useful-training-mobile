package trainingbuilder.training_builder.pages.set_exercise

import androidx.compose.runtime.Immutable
import trainingbuilder.training_builder.models.Exercise
import trainingbuilder.training_builder.models.IterationTargetFocus

@Immutable
internal data class SetExerciseState(
    val exercise: Exercise,
    val focusTarget: Pair<Int, IterationTargetFocus> = -1 to IterationTargetFocus.Weight
)