package profile.main

import androidx.compose.runtime.Immutable
import profile.main.models.User

@Immutable
internal data class State(
    val user: User = User(),

    val error: String? = null,
    val loading: Boolean = false
)
