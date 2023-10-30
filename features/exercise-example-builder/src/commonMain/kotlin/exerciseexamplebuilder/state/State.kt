package exerciseexamplebuilder.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val exerciseExample: ExerciseExample? = null,
    val availableMuscles: ImmutableList<Muscle> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false,

    val sliderRange: ClosedRange<Int> = 0..100,
    val minimalRange: Int = 5
)
