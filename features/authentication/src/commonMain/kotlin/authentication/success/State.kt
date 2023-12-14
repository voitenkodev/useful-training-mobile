package authentication.success

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val name: String = "",
    val height: String = "",
    val weight: String = "",
    val error: String? = null
)