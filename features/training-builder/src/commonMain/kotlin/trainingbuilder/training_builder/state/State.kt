package trainingbuilder.training_builder.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import trainingbuilder.training_builder.factory.createFrontBackImages

@Immutable
internal data class State(
    val training: Training = Training(),

    val muscles: ImmutableList<Muscle> = persistentListOf(),
    val selectedMuscle: Muscle? = null,
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    val setExerciseState: SetExerciseState = SetExerciseState.Closed,
    val findExercisePopupIsVisibleIndex: Boolean = false,
    val recommendationsLoading: Boolean = false,

    val fullFrontImageVector: ImageVector = training.exercises.createFrontBackImages().first,
    val fullBackImageVector: ImageVector = training.exercises.createFrontBackImages().second,

    val error: String? = null,
    val loading: Boolean = false
)