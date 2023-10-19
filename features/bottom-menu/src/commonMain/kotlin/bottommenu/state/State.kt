package bottommenu.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val error: String? = null,
    val loading: Boolean = false
)