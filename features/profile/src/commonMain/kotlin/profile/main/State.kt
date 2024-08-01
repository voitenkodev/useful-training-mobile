package profile.main

import androidx.compose.runtime.Immutable
import user.User

@Immutable
internal data class State(
    val user: User? = null,

    val error: String? = null,
    val loading: Boolean = false
)
