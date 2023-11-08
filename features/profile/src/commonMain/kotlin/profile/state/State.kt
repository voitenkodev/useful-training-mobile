package profile.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val user: User = User(),

    val error: String? = null,
    val loading: Boolean = false
)
