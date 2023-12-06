package trainingbuilder.builder.state

import androidx.compose.runtime.Immutable

@Immutable
internal sealed class SetExercisePopupState(open val index: Int) {
    data object Closed : SetExercisePopupState(-1)
    data class Opened(override val index: Int, val exerciseExample: ExerciseExample?) : SetExercisePopupState(index)
}
