package authentication.splash

import androidx.compose.runtime.Immutable
import authentication.splash.models.TokenStatus

@Immutable
internal data class State(
    val tokenStatus: TokenStatus = TokenStatus.Unknown
)