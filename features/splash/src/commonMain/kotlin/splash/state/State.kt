package splash.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val tokenStatus: TokenStatus = TokenStatus.Unknown,
    val error: String? = null,
    val loading: Boolean = false
)