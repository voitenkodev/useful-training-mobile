package authentication.intro

import androidx.compose.runtime.Immutable
import authentication.intro.models.ScreenState

@Immutable
internal data class State(
    val screenState: ScreenState = ScreenState.Default
)