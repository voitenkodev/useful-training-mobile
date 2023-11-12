package musclepicker.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val muscleTypes: ImmutableList<MuscleType> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
