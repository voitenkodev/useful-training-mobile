package trainingbuilder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val training: Training = Training(),

    val muscles: ImmutableList<Muscle> = persistentListOf(),
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    val setExercisePopupIsVisibleIndex: Int? = null,

    val error: String? = null,
    val loading: Boolean = false
)