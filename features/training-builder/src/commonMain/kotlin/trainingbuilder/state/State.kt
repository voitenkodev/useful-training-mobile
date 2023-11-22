package trainingbuilder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val training: Training = Training(),

    val muscleTypes: ImmutableList<MuscleType> = persistentListOf(),

    val setExercisePopupIsVisible: Boolean = false,

    val error: String? = null,
    val loading: Boolean = false
)