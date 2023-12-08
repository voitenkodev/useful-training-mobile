package trainingbuilder.builder.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import musclepickerpicker.fullBack
import musclepickerpicker.fullFront

@Immutable
internal data class State(
    val training: Training = Training(),

    val muscles: ImmutableList<Muscle> = persistentListOf(),
    val selectedMuscle: Muscle? = null,
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    val setExercisePopupState: SetExercisePopupState = SetExercisePopupState.Closed,
    val findExercisePopupIsVisibleIndex: Boolean = false,

    val fullFrontImageVector: ImageVector = fullFront(),
    val fullBackImageVector: ImageVector = fullBack(),

    val error: String? = null,
    val loading: Boolean = false
)