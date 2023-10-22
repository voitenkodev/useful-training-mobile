package statistics.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentHashMapOf
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val query: String = "",
    val exercises: ImmutableMap<Info, ImmutableList<Exercise>> = persistentHashMapOf(),
    val exerciseNameOptions: ImmutableList<String> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
