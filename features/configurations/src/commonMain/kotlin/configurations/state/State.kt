package configurations.state

import androidx.compose.runtime.Immutable
import configurations.popups.ExerciseExampleState
import configurations.popups.MusclePopupState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),
    val muscles: ImmutableList<Muscle> = persistentListOf(),
    val selectedMuscleId: ImmutableList<Muscle> = persistentListOf(),
    val musclePopupState: MusclePopupState? = null,
    val exerciseExamplePopupState: ExerciseExampleState? = null,
    val error: String? = null,
    val loading: Boolean = false
)
