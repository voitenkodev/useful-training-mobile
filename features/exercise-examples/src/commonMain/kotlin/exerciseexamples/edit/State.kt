package exerciseexamples.edit

import androidx.compose.runtime.Immutable
import exerciseexamples.edit.state.ExerciseExample
import exerciseexamples.edit.state.MuscleType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val exerciseExample: ExerciseExample? = null,
    val muscleTypes: ImmutableList<MuscleType> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false,

    val sliderRange: ClosedRange<Int> = 0..100,
    val minimalRange: Int = 3
)
