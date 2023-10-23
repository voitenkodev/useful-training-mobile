package configurations.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val exerciseNameOptions: ImmutableList<String> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
