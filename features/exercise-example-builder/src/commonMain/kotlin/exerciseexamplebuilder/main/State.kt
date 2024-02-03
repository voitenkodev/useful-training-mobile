package exerciseexamplebuilder.main

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val name: String = "",

    val error: String? = null,
    val loading: Boolean = false
)
