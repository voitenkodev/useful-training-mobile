package trainingbuilder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList

@Immutable
internal data class State(
    val training: Training = Training(),

    val selectedStep: TrainingBuilderSteps = TrainingBuilderSteps.Configurations,
    val steps: ImmutableList<TrainingBuilderSteps> = TrainingBuilderSteps.entries.toPersistentList(),

    val muscleTypes: ImmutableList<MuscleType> = persistentListOf(),
    val musclePickerPopupVisible: Boolean = false,

    val preferredDuration: Int = 15,

    val editExercisePopupIsVisible: Boolean = false,

    val error: String? = null,
    val loading: Boolean = false
)