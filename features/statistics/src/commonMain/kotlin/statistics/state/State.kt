package statistics.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val query: String = "",
    val exercises: Map<Info, List<Exercise>> = mapOf(),
    val exerciseNameOptions: List<String> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false
)
