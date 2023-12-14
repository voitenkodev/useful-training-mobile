package trainingbuilder.training_builder.models

import androidx.compose.runtime.Immutable

@Immutable
internal sealed class SetExerciseState(open val index: Int) {
    data object Closed : SetExerciseState(-1)
    data class Opened(override val index: Int, val exerciseExample: ExerciseExample?) : SetExerciseState(index)
}
