package authentication.state

import androidx.compose.runtime.Immutable

@Immutable
data class State(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)